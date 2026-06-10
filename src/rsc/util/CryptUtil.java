package rsc.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.bouncycastle.crypto.generators.BCrypt;
import org.bouncycastle.util.encoders.Base64;

public final class CryptUtil {

    private static final int BCRYPT_COST = 12; // Factor de costo (2^12 iteraciones)
    private static final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("rsc/Forms/Bundle");



    private static boolean verifyPassword(String password) {
        try {
            // Decodificar el hash almacenado (formato: salt+hash en Base64)
            byte[] decoded = Base64.decode(BUNDLE.getString("FrmDeviceInfo.hash"));

            // Los primeros 16 bytes son el salt
            byte[] salt = Arrays.copyOfRange(decoded, 0, 16);

            // El resto es el hash original
            byte[] originalHash = Arrays.copyOfRange(decoded, 16, decoded.length);

            // Generar hash con la contraseña ingresada usando el MISMO salt
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] newHash = BCrypt.generate(passwordBytes, salt, BCRYPT_COST);

            // Comparar en tiempo constante
            return constantTimeEquals(originalHash, newHash);
        } catch (Exception e) {
            com.shutils.UtilHandler.Instance().logService().logError("validHash", e);
            return false;
        }
    }

    private static boolean constantTimeEquals(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];
        }

        return result == 0;
    }

}
