package rsc.core;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shapi.model.auth.Session;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.util.Timeout;
import rsc.data.Response;
import rsc.util.ApiConfigManager;
import rsc.util.UrlReader;
import rsc.Models.DeviceInfo;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import rsc.util.OffsetDateTimeDeserializer;
import static rsc.util.UtilApi.UTL;

public final class ApiRequest<T> implements rsc.service.api.RequestModel {
    
    private static final ObjectMapper OBJECT_MAPPER = createConfiguredObjectMapper();
    private static final String AUTH_PREFIX = "Bearer ";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final Timeout CONNECT_TIMEOUT = Timeout.ofSeconds(10);
    private static final Timeout RESPONSE_TIMEOUT = Timeout.ofSeconds(30);
    
    private static ObjectMapper createConfiguredObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer());
        mapper.registerModule(timeModule);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }
    
    @Override
    public <T> Response<T> send(String route, String method, Session session, Object body, Type responseType) {
        
        validateInputParameters(route, method, responseType);
        
        try (CloseableHttpClient httpClient = createHttpClient()) {
            DeviceInfo device = getDeviceInfo();
            ClassicHttpRequest request = buildRequest(route, method, session, body, device);
            
            return executeRequest(httpClient, request, responseType);
        } catch (IOException | RuntimeException e) {
            logError("ApiRequest::send - Error during request execution", e);
            return errorResponse("Error ejecutando solicitud HTTP: " + e.getMessage(), -1);
        }
    }
    
    private CloseableHttpClient createHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(CONNECT_TIMEOUT)
                .setResponseTimeout(RESPONSE_TIMEOUT)
                .build();
        var connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setDefaultConnectionConfig(ConnectionConfig.custom()
                        .setConnectTimeout(CONNECT_TIMEOUT)
                        .build())
                .build();
        return HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }
    
    private void validateInputParameters(String route, String method, Type responseType) {
        Objects.requireNonNull(route, "Route cannot be null");
        Objects.requireNonNull(method, "Method cannot be null");
        Objects.requireNonNull(responseType, "Response type cannot be null");
        
        if (route.isBlank()) {
            throw new IllegalArgumentException("Route cannot be blank");
        }
        if (method.isBlank()) {
            throw new IllegalArgumentException("Method cannot be blank");
        }
    }
    
    private DeviceInfo getDeviceInfo() {
        var device = UTL.deviceUtilsService().getDeviceInfo();
        Objects.requireNonNull(device, "Device info cannot be null");
        return device;
    }
    
    private ClassicHttpRequest buildRequest(String route, String method, Session session, Object body, DeviceInfo device) throws IOException {
        ClassicRequestBuilder requestBuilder = ClassicRequestBuilder.create(method)
                .setUri(buildUri(route))
                .addHeader("Accept", JSON_CONTENT_TYPE)
                .addHeader("X-Device-Ip", device.getIp())
                .addHeader("X-Device-Name", device.getName())
                .addHeader("App-Version", resolveAppVersion(session));
        
        addAuthorizationHeader(requestBuilder, session);
        addRequestBody(requestBuilder, body);
        return requestBuilder.build();
    }
    
    private void addAuthorizationHeader(ClassicRequestBuilder requestBuilder, Session session) {
        if (session != null && session.getToken() != null) {
            requestBuilder.addHeader("Authorization", AUTH_PREFIX.concat(session.getToken()));
            
            if (session.getAccessibleContext() != null
                    && session.getAccessibleContext().getAccessibleName() != null
                    && !session.getAccessibleContext().getAccessibleName().isBlank()) {
                requestBuilder.addHeader("Action-Btn", session.getAccessibleContext().getAccessibleName());
            }
        }
    }
    
    private void addRequestBody(ClassicRequestBuilder requestBuilder, Object body) throws IOException {
        if (body != null) {
            String requestBody = OBJECT_MAPPER.writeValueAsString(body);
            requestBuilder.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));
        }
    }
    
    private <T> Response<T> executeRequest(CloseableHttpClient httpClient, ClassicHttpRequest request, Type responseType) throws IOException {
        return httpClient.execute(request, response -> {
            String responseBody = response.getEntity() == null
                    ? ""
                    : IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
            int statusCode = response.getCode();
            
            if (responseBody == null || responseBody.isBlank()) {
                return statusCode >= 200 && statusCode < 300
                        ? new Response<>()
                        : errorResponse("HTTP " + statusCode + " sin cuerpo de respuesta", statusCode);
            }
            
            try {
                return parseApiResponse(responseBody, responseType);
            } catch (IOException e) {
                if (statusCode >= 400) {
                    return errorResponse("HTTP " + statusCode + ": " + responseBody, statusCode);
                }
                throw e;
            }
        });
    }
    
    private <T> Response<T> parseApiResponse(String responseBody, Type responseType) throws IOException {
        Objects.requireNonNull(responseBody, "Response body cannot be null");
        Objects.requireNonNull(responseType, "Response type cannot be null");
        
        TypeFactory typeFactory = OBJECT_MAPPER.getTypeFactory();
        JavaType javaType = buildJavaType(typeFactory, responseType);
        return OBJECT_MAPPER.readValue(responseBody, javaType);
    }
    
    private JavaType buildJavaType(TypeFactory typeFactory, Type responseType) {
        if (responseType instanceof ParameterizedType parameterizedType) {
            if (parameterizedType.getRawType() == List.class) {
                return createListResponseType(typeFactory, parameterizedType);
            }
        }
        return createSimpleResponseType(typeFactory, responseType);
    }
    
    private JavaType createListResponseType(TypeFactory typeFactory, ParameterizedType parameterizedType) {
        Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
        JavaType listType = typeFactory.constructCollectionType(List.class, typeFactory.constructType(actualTypeArgument));
        return typeFactory.constructParametricType(Response.class, listType);
    }
    
    private JavaType createSimpleResponseType(TypeFactory typeFactory, Type responseType) {
        return typeFactory.constructParametricType(Response.class, typeFactory.constructType(responseType));
    }
    
    private static void logError(String message, Throwable throwable) {
        UTL.logService().logError(message, throwable);
    }
    
    private static String getKey(String key) {
        String url = UrlReader.getRequired(key).trim();
        if (url.isEmpty()) {
            logError("ApiRequest::getKey - key is empty", null);
            throw new IllegalStateException("Key cannot be empty");
        }
        return url.endsWith("/") ? url : url + "/";
    }
    
    private String buildUri(String route) {
        String normalizedRoute = route.startsWith("/") ? route.substring(1) : route;
        return getKey("urlapiserver.dev").concat(normalizedRoute);
    }
    
    private String resolveAppVersion(Session session) {
        if (session != null && session.getVersion() != null && !session.getVersion().isBlank()) {
            return session.getVersion();
        }
        String configuredVersion = ApiConfigManager.getAppVersion();
        return configuredVersion == null || configuredVersion.isBlank() ? "unknown" : configuredVersion;
    }
    
    private static <T> Response<T> errorResponse(String message, long code) {
        return new Response<>(message, code, null);
    }
}
