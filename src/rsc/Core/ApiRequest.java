package rsc.Core;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shapi.Models.auth.Session;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import rsc.Data.Response;
import rsc.Utility.UrlReader;
import rsc.Models.DeviceInfo;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import rsc.Utility.OffsetDateTimeDeserializer;
import static rsc.Utility.UtilApi.UTL;

public final class ApiRequest<T> implements rsc.Services.api.RequestModel {

    private static final ObjectMapper OBJECT_MAPPER = createConfiguredObjectMapper();
    private static final String AUTH_PREFIX = "Bearer ";
    private static final String APP_VERSION = "1.0.0";
    private static final String JSON_CONTENT_TYPE = "application/json";

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
        validateInputParameters(route, method);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            DeviceInfo device = getDeviceInfo();
            ClassicHttpRequest request = buildRequest(route, method, session, body, device);

            return executeRequest(httpClient, request, responseType);
        } catch (IOException | NullPointerException e) {
            logError("ApiRequest::send - Error during request execution", e);
            return null;
        }
    }

    private void validateInputParameters(String route, String method) {
        Objects.requireNonNull(route, "Route cannot be null");
        Objects.requireNonNull(method, "Method cannot be null");
    }

    private DeviceInfo getDeviceInfo() {
        var device = UTL.deviceUtilsService().getDeviceInfo();
        Objects.requireNonNull(device, "Device info cannot be null");
        return device;
    }

    private ClassicHttpRequest buildRequest(String route, String method, Session session, Object body, DeviceInfo device) throws IOException {
        ClassicRequestBuilder requestBuilder = ClassicRequestBuilder.create(method)
                .setUri(getBaseUrl().concat(route))
                .addHeader("Accept", JSON_CONTENT_TYPE)
                .addHeader("X-Device-Ip", device.getIp())
                .addHeader("X-Device-Name", device.getName())
                .addHeader("App-Version", APP_VERSION);

        addAuthorizationHeader(requestBuilder, session);
        addRequestBody(requestBuilder, body);

        return requestBuilder.build();
    }

    private void addAuthorizationHeader(ClassicRequestBuilder requestBuilder, Session session) {
        if (session != null && session.getToken() != null) {
            requestBuilder.addHeader("Authorization", AUTH_PREFIX.concat(session.getToken()));
            requestBuilder.addHeader("Action-Btn", session.getAccessibleContext().getAccessibleName());
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
            String responseBody = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
            return parseApiResponse(responseBody, responseType);
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

    private static String getBaseUrl() {
        String url = UrlReader.getOrDefault("url", "").trim();
        if (url.isEmpty()) {
            logError("ApiRequest::getBaseUrl - URL is empty", null);
            throw new IllegalStateException("Base URL cannot be empty");
        }
        return url.endsWith("/") ? url : url + "/";
    }
}
