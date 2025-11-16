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

    private static final String PROPERTIES_PATH = "./props.properties"; // Debe estar en resources
    private static final Properties PROPERTIES = new Properties();

    static {
        // Carga las properties una sola vez
        try (InputStream input = UrlReader.class.getResourceAsStream(PROPERTIES_PATH)) {
            if (input == null) {
                throw new IOException("No se pudo encontrar el archivo " + PROPERTIES_PATH);
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            UTL.logService().logError("UrlReader - Error al cargar properties", e);
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
        return PROPERTIES.getProperty(key);
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
}
