package rsc.Utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.accessibility.AccessibleContext;
import static rsc.Utility.UtilApi.UTL;

public final class RouteHelper {

    private static final Properties props = new Properties();
    private static final String BASE_KEY_BUTTON = "button.";

    static {
        try (InputStream in = RouteHelper.class.getResourceAsStream("./routes.properties")) {
            if (in != null) {
                props.load(in);
            } else {
                UTL.logService().logError("Archivo routes.properties no encontrado", null);
            }
        } catch (IOException e) {
            UTL.logService().logError("Error al cargar rutas", e);
        }
    }

    /**
     * Obtiene la ruta de un botón desde el archivo properties.
     *
     * @param action Clave del botón, sin prefijo. Ej: "btnLogin"
     * @return Objeto ButtonRoute con URL, método y si requiere autenticación
     */
    public static ButtonRoute getButtonRoute(String action) {
        String routeKey = BASE_KEY_BUTTON + action;
        String url = props.getProperty(routeKey);
        String method = props.getProperty(routeKey + ".method", "GET");
        boolean requiresAuth = Boolean.parseBoolean(props.getProperty(routeKey + ".requiresAuth", "false"));

        if (url == null) {
            UTL.logService().logError("Ruta no definida para botón: " + action, null);
            url = "";
            UTL.AlertService().error(null, "Internal Router Error.");
        }

        return new ButtonRoute(url, method.toUpperCase(), requiresAuth);
    }

    /**
     * Reemplaza un marcador {codigo} en la ruta con un valor.
     *
     * @param action Accion de Boton
     * @param value Valor a insertar en el marcador
     * @return Ruta final con el valor reemplazado
     */
    public static String buildRouteWithParam(String action, String value) {

        String url = getButtonRoute(action).getUrl();

        if (url == null || !url.contains("{param}")) {
            UTL.logService().logError("La ruta no contiene el marcador {param}", null);
            UTL.AlertService().error(null, "Internal Router Error.");
            return url != null ? url : "";
        }

        return url.replace("{param}", value);
    }

    public static String buildRouteWithParam(String action, int value) {

        String url = getButtonRoute(action).getUrl();

        if (url == null || !url.contains("{param}")) {
            UTL.logService().logError("La ruta no contiene el marcador {param}", null);
            UTL.AlertService().error(null, "Internal Router Error.");
            return url != null ? url : "";
        }

        return url.replace("{param}", String.valueOf(value));
    }

    public static ButtonRoute buildRoute(AccessibleContext accessibleContext, Object... param) {
        String accessibleDescription = accessibleContext.getAccessibleDescription();

        if (accessibleDescription == null || accessibleDescription.isEmpty()) {
            UTL.AlertService().error(null, "AccessibleDescription no puede estar vacío.");
            return null;
        }

        String[] array = accessibleDescription.split(":");
        if (array.length < 2) {
            UTL.AlertService().error(null, "AccessibleDescription incompleto.");
            return null;
        }

        String method = array[0];
        String url = array[1];

        // Con parámetros
        if (param != null && param.length > 0) {
            if (url.contains("{param}")) {
                String newUrl = url.replace("{param}", String.valueOf(param[0]));
                return new ButtonRoute(newUrl, method, true);
            } else {
                UTL.AlertService().error(null, "La ruta requiere {param}.");
                return null;
            }
        }

        // Sin parámetros
        return new ButtonRoute(url, method, true);
    }

}
