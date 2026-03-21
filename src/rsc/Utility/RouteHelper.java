package rsc.Utility;


import javax.accessibility.AccessibleContext;
import static rsc.Utility.UtilApi.UTL;

public final class RouteHelper {

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

    public static ButtonRoute buildRoutePaged(AccessibleContext accessibleContext, Object... param) {
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

            String newUrl = url.replace("paged", String.valueOf("?page=" + param[0]));
            return new ButtonRoute(newUrl, method, true);

        }

        // Sin parámetros
        return new ButtonRoute(url, method, true);
    }
}
