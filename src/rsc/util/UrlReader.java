package rsc.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Objects;
import static rsc.util.UtilApi.UTL;

/**
 * Provides utility methods for reading URLs from a properties file. The
 * properties file is loaded from the classpath during class initialization.
 */
public final class UrlReader {

    private static final String PROPERTIES_PATH = "con_local.properties";
    private static final String CONFIG_FILE_PROPERTY = "apishadai.config.file";
    private static final String CONFIG_FILE_ENV = "APISHADAI_CONFIG_FILE";
    private static final String CONFIG_VALUE_PROPERTY_PREFIX = "apishadai.config.";
    private static final String CONFIG_VALUE_ENV_PREFIX = "APISHADAI_";
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            try (InputStream input = openConfigStream()) {
                PROPERTIES.load(input);
            }

        } catch (IOException | RuntimeException e) {
            UTL.logService().logError("Error cargando configuración->UrlReader", e);
            throw new IllegalStateException("Error cargando configuracion de API", e);
        }
    }

    private static InputStream openConfigStream() throws IOException {
        String externalPath = firstNonBlank(
                System.getProperty(CONFIG_FILE_PROPERTY),
                System.getenv(CONFIG_FILE_ENV)
        );

        if (externalPath != null) {
            return Files.newInputStream(Path.of(externalPath));
        }

        InputStream input = UrlReader.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH);
        if (input == null) {
            throw new IOException("No se encontro " + PROPERTIES_PATH
                    + ". Defina " + CONFIG_FILE_ENV + " o -D" + CONFIG_FILE_PROPERTY);
        }
        return input;
    }

    /**
     * Retorna el valor de cualquier key en props.properties
     *
     * @param key clave a buscar
     * @return valor de la clave o null si no existe
     */
    public static String get(String key) {
        Objects.requireNonNull(key, "key cannot be null");

        String externalValue = getExternalValue(key);
        if (externalValue != null) {
            return externalValue;
        }

        String plainValue = PROPERTIES.getProperty(key);
        if (plainValue != null) {
            return plainValue.trim();
        }

        return null;
    }

    /**
     * Retorna el valor de cualquier key, pero si no existe devuelve un valor
     * por defecto
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getOrDefault(String key, String defaultValue) {
        String value = get(key);
        return value != null ? value : defaultValue;
    }

    public static String getRequired(String key) {
        String value = get(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("No se encontro la configuracion requerida: " + key);
        }
        return value;
    }

    private static String firstNonBlank(String... values) {
        for (String value : values) {
            if (value != null && !value.isBlank()) {
                return value.trim();
            }
        }
        return null;
    }

    private static String getExternalValue(String key) {
        String propertyValue = System.getProperty(CONFIG_VALUE_PROPERTY_PREFIX + key);
        if (propertyValue != null && !propertyValue.isBlank()) {
            return propertyValue.trim();
        }

        String envKey = CONFIG_VALUE_ENV_PREFIX + key.toUpperCase().replaceAll("[^A-Z0-9]", "_");
        String envValue = System.getenv(envKey);
        return envValue == null || envValue.isBlank() ? null : envValue.trim();
    }

    private UrlReader() {
    }
}
