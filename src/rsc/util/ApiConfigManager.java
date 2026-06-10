package rsc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static rsc.util.UtilApi.UTL;

public final class ApiConfigManager {

    private static final String CONFIG_FILE = "apishadai_version.properties";
    private static final Properties PROPS = new Properties();
    private static String appVersion;

    static {
        try {
            try (InputStream input = ApiConfigManager.class
                    .getClassLoader()
                    .getResourceAsStream(CONFIG_FILE)) {

                if (input == null) {
                    throw new RuntimeException("No se encontró " + CONFIG_FILE);
                }

                PROPS.load(input);
                appVersion = PROPS.getProperty("app.version", null);

            }

        } catch (IOException | RuntimeException e) {
            UTL.logService().logError("Error cargando configuración->ApiConfigManager", e);
            throw new IllegalStateException("Error cargando configuracion de version", e);
        }
    }

    public static String getAppVersion() {
        return appVersion;
    }

    private ApiConfigManager() {
    }
}
