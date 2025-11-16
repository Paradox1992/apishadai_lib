package rsc.Core;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shapi.Models.auth.Session;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import rsc.Data.Response;
import rsc.Models.DeviceInfo;
import rsc.Utility.OffsetDateTimeDeserializer;
import rsc.Utility.UrlReader;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.*;

import static rsc.Utility.UtilApi.UTL;

public final class ApiRequest<T> implements rsc.Services.api.RequestModel {

    private static final ObjectMapper OBJECT_MAPPER = JsonMapper.builder()
            .addModule(new JavaTimeModule().addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer()))
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .build();

    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.custom()
            .evictExpiredConnections()
            .evictIdleConnections(TimeValue.ofMinutes(1))
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setResponseTimeout(Timeout.ofSeconds(30))
                    .setConnectionRequestTimeout(Timeout.ofSeconds(5))
                    .build())
            .build();

    @Override
    public <T> Response<T> send(String route, String method, Session session, Object body, Type responseType) {
        if (!UTL.deviceUtilsService().checkConnection()) {
            UTL.AlertService().error(null, "Sin Conexión al Servidor!");
            return new Response<>("Sin conexión al servidor", 0, null, null);
        }

        Objects.requireNonNull(route, "Route cannot be null");
        Objects.requireNonNull(method, "Method cannot be null");

        method = validateHttpMethod(method);

        try {
            DeviceInfo device = getDeviceInfo();
            ClassicHttpRequest request = buildRequest(route, method, session, body, device);
            return executeRequest(request, responseType);
        } catch (IOException e) {
            logError("ApiRequest::send - Network error", e);
            return new Response<>("Network error", 500, null, null);
        } catch (Exception e) {
            logError("ApiRequest::send - Internal error", e);
            return new Response<>("Error interno en la petición", 500, null, null);
        }
    }

    private static String validateHttpMethod(String method) {
        method = method.toUpperCase();
        return switch (method) {
            case "GET", "POST", "PUT", "DELETE" ->
                method;
            default ->
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        };
    }

    private DeviceInfo getDeviceInfo() {
        var device = UTL.deviceUtilsService().getDeviceInfo();
        return Objects.requireNonNull(device, "Device info cannot be null");
    }

    private ClassicHttpRequest buildRequest(String route, String method, Session session, Object body, DeviceInfo device) throws IOException {
        URI uri = URI.create(getBaseUrl()).resolve(route);

        ClassicRequestBuilder requestBuilder = ClassicRequestBuilder.create(method)
                .setUri(uri)
                .addHeader("Accept", getJsonContentType())
                .addHeader("X-Device-Ip", device.getIp())
                .addHeader("X-Device-Name", device.getName())
                .addHeader("App-Version", getAppVersion());

        addAuthorizationHeader(requestBuilder, session);

        if (body != null) {
            String requestBody = OBJECT_MAPPER.writeValueAsString(body);
            requestBuilder.setEntity(new StringEntity(requestBody, ContentType.APPLICATION_JSON));
        }

        return requestBuilder.build();
    }

    private void addAuthorizationHeader(ClassicRequestBuilder requestBuilder, Session session) {
        if (session != null && session.getToken() != null) {
            requestBuilder.addHeader("Authorization", getAuthPrefix().concat(session.getToken()));
            if (session.getAccessibleContext() != null && session.getAccessibleContext().getAccessibleName() != null) {
                requestBuilder.addHeader("Action-Btn", session.getAccessibleContext().getAccessibleName());
            }
        }
    }

    private <T> Response<T> executeRequest(ClassicHttpRequest request, Type responseType) throws IOException {
        return HTTP_CLIENT.execute(request, response -> {
            int status = response.getCode();
            String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
            Response<T> parsed = parseApiResponse(body, responseType);
            if (parsed.getCode() == 0) {
                return new Response<>(parsed.getMessage(), status, parsed.getData(), parsed.getMeta());
            }
            return parsed;
        });
    }

    /**
     * Parser que soporta: - Response<T> estándar (message, code, data, meta) -
     * JSON plano con data tipo objeto, lista o boolean - Colección paginada con
     * meta + data
     */
    @SuppressWarnings("unchecked")
    private <T> Response<T> parseApiResponse(String responseBody, Type responseType) throws IOException {
        Objects.requireNonNull(responseBody, "Response body cannot be null");
        Objects.requireNonNull(responseType, "Response type cannot be null");

        // Lee el JSON como Map genérico para inspeccionar estructura
        Map<String, Object> map = OBJECT_MAPPER.readValue(responseBody, Map.class);

        boolean hasStandardFields = map.containsKey("message") && map.containsKey("code") && map.containsKey("data");

        if (hasStandardFields) {
            // Si contiene "meta", usar Response<T> con PgInfo
            Object metaObj = map.get("meta");

            // Construir tipo genérico para Response<T>
            JavaType dataType = OBJECT_MAPPER.getTypeFactory().constructType(responseType);
            JavaType wrapperType = OBJECT_MAPPER.getTypeFactory()
                    .constructParametricType(Response.class, dataType);

            Response<T> parsed = OBJECT_MAPPER.readValue(responseBody, wrapperType);

            // Si meta existe pero está vacío o null, mantener null
            if (metaObj == null || (metaObj instanceof Map && ((Map<?, ?>) metaObj).isEmpty())) {
                return new Response<>(parsed.getMessage(), parsed.getCode(), parsed.getData(), null);
            }

            return parsed;
        } else {
            // Caso no envuelto: el servidor devolvió solo el objeto o valor booleano
            T data = OBJECT_MAPPER.readValue(responseBody, OBJECT_MAPPER.getTypeFactory().constructType(responseType));
            return new Response<>("OK", 200, data, null);
        }
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

    private static String getAuthPrefix() {
        return UrlReader.get("auth.prefix");
    }

    private static String getAppVersion() {
        return UrlReader.get("app.version");
    }

    private static String getJsonContentType() {
        return UrlReader.get("json.content.type");
    }

    public static void shutdown() {
        try {
            HTTP_CLIENT.close();
        } catch (IOException e) {
            logError("Error closing HTTP client", e);
        }
    }

    public static ObjectMapper getMapper() {
        return OBJECT_MAPPER;
    }
}
