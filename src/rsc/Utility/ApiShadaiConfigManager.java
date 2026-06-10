package rsc.Utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static rsc.Utility.UtilApi.UTL;

public final class ApiShadaiConfigManager {

    private static final String CONFIG_FILE = "apishadai_version.properties";
    private static final Properties PROPS = new Properties();
    private static String appVersion;

    static {
        try {
            try (InputStream input = ApiShadaiConfigManager.class
                    .getClassLoader()
                    .getResourceAsStream(CONFIG_FILE)) {

                if (input == null) {
                    throw new RuntimeException("No se encontró " + CONFIG_FILE);
                }

                PROPS.load(input);
                appVersion = PROPS.getProperty("app.version", null);

            }

        } catch (IOException | RuntimeException e) {
            UTL.logService().logError("Error cargando configuración->ApiShadaiConfigManager", e);
            UTL.AlertService().error(null, "Error cargando configuración->ApiShadaiConfigManager");
            System.exit(0);
        }
    }

    public static String getAppVersion() {
        return appVersion;
    }

    private ApiShadaiConfigManager() {
    }
}