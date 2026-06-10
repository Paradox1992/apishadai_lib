package rsc.util;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import javax.accessibility.AccessibleContext;

public final class RouteHelper {

    public static ButtonRoute buildRoute(AccessibleContext accessibleContext, Object... param) {
        String[] routeParts = parseRoute(accessibleContext);
        String method = routeParts[0];
        String url = routeParts[1];

        if (param != null && param.length > 0) {
            if (url.contains("{param}")) {
                String newUrl = url.replace("{param}", encodeParam(param[0]));
                return new ButtonRoute(newUrl, method, true);
            }
            throw new IllegalArgumentException("La ruta requiere el marcador {param}: " + url);
        }

        return new ButtonRoute(url, method, true);
    }

    public static ButtonRoute buildRoutePaged(AccessibleContext accessibleContext, Object... param) {
        String[] routeParts = parseRoute(accessibleContext);
        String method = routeParts[0];
        String url = routeParts[1];

        if (param != null && param.length > 0) {
            return new ButtonRoute(applyPage(url, param[0]), method, true);
        }

        return new ButtonRoute(url, method, true);
    }

    private static String[] parseRoute(AccessibleContext accessibleContext) {
        Objects.requireNonNull(accessibleContext, "AccessibleContext cannot be null");

        String accessibleDescription = accessibleContext.getAccessibleDescription();
        if (accessibleDescription == null || accessibleDescription.isBlank()) {
            throw new IllegalArgumentException("AccessibleDescription no puede estar vacio.");
        }

        String[] array = accessibleDescription.split(":", 2);
        if (array.length < 2 || array[0].isBlank() || array[1].isBlank()) {
            throw new IllegalArgumentException("AccessibleDescription incompleto: " + accessibleDescription);
        }

        return new String[]{array[0].trim().toUpperCase(), array[1].trim()};
    }

    private static String applyPage(String url, Object page) {
        String encodedPage = encodeParam(page);

        if (url.contains("{page}")) {
            return url.replace("{page}", encodedPage);
        }
        if (url.contains("paged")) {
            return url.replace("paged", "?page=" + encodedPage);
        }

        String separator = url.contains("?") ? "&" : "?";
        return url + separator + "page=" + encodedPage;
    }

    private static String encodeParam(Object value) {
        Objects.requireNonNull(value, "Route parameter cannot be null");
        return URLEncoder.encode(String.valueOf(value), StandardCharsets.UTF_8);
    }
}
