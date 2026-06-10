package rsc.Utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static rsc.Utility.UtilApi.UTL;

/**
 * Provides utility methods for reading URLs from a properties file. The
 * properties file is loaded from the classpath during class initialization.
 */
public final class UrlReader {

    private static final String PROPERTIES_PATH = "con_local.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            try (InputStream input = UrlReader.class
                    .getClassLoader()
                    .getResourceAsStream(PROPERTIES_PATH)) {

                if (input == null) {
                    throw new RuntimeException("No se encontró " + PROPERTIES_PATH);
                }

                PROPERTIES.load(input);

            }

        } catch (IOException | RuntimeException e) {
            UTL.logService().logError("Error cargando configuración->UrlReader", e);
            UTL.AlertService().error(null, "Error cargando configuración->UrlReader");
            System.exit(0);
        }
    }

    /**
     * Retorna el valor de cualquier key en props.properties
     *
     * @param key clave a buscar
     * @return valor de la clave o null si no existe
     */
    public static String get(String key) {
        String normalizedKey = CryptoManager.getInstance()
                .encrypt(key)
                .replaceAll("=+$", "");
        String encryptedValue = PROPERTIES.getProperty(normalizedKey, null);
        if (encryptedValue == null) {
            return null;
        }
        // Quitar el = inicial que agrega el parser
        String cleanValue = encryptedValue.replaceAll("^=+", "");
        return CryptoManager.getInstance().decrypt(cleanValue);
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
        return PROPERTIES.getProperty(key, defaultValue);
    }

    private UrlReader() {
    }
}