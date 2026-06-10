package rsc.util;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import static rsc.util.UtilApi.UTL;

public final class CryptoManager {

    private static final String SECRET_PROPERTY = "apishadai.crypto.secret";
    private static final String SECRET_ENV = "APISHADAI_CRYPTO_SECRET";
    private static final String SALT = "6a6b3ad844e9c42eca2483556dae9c51";
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String KEY_FACTORY = "PBKDF2WithHmacSHA256";
    private static final byte[] IV_BYTES = {
        0x41, 0x70, 0x70, 0x43,
        0x6F, 0x6E, 0x66, 0x69,
        0x67, 0x49, 0x56, 0x31,
        0x36, 0x42, 0x79, 0x74
    };

    private static volatile CryptoManager instance;

    private CryptoManager() {
    }

    public static CryptoManager getInstance() {
        CryptoManager localInstance = instance;
        if (localInstance == null) {
            synchronized (CryptoManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new CryptoManager();
                    instance = localInstance;
                }
            }
        }
        return localInstance;
    }

    public String encrypt(String plainText) {
        Objects.requireNonNull(plainText, "plainText cannot be null");
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, buildKey(), buildIv());
            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            UTL.logService().logError("CryptoManager:encrypt", e);
            throw new IllegalStateException("No se pudo cifrar el texto", e);
        }

    }

    public String decrypt(String encryptedText) {
        Objects.requireNonNull(encryptedText, "encryptedText cannot be null");
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, buildKey(), buildIv());
            byte[] decoded = Base64.getDecoder().decode(encryptedText);
            return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
        } catch (Exception e) {
            UTL.logService().logError("CryptoManager:decrypt", e);
            throw new IllegalStateException("No se pudo descifrar el texto", e);
        }
    }

    private SecretKey buildKey() throws Exception {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_FACTORY);
            KeySpec spec = new PBEKeySpec(
                    resolveSecretPassword().toCharArray(),
                    SALT.getBytes(StandardCharsets.UTF_8),
                    65536,
                    256
            );
            return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | IllegalArgumentException e) {
            UTL.logService().logError("CryptoManager:buildKey", e);
            throw e;
        }
    }

    private String resolveSecretPassword() {
        String secret = System.getProperty(SECRET_PROPERTY);
        if (secret == null || secret.isBlank()) {
            secret = System.getenv(SECRET_ENV);
        }
        if (secret == null || secret.isBlank()) {
            throw new IllegalStateException("Defina " + SECRET_ENV + " o -D" + SECRET_PROPERTY);
        }
        return secret;
    }

    private IvParameterSpec buildIv() {
        return new IvParameterSpec(IV_BYTES);
    }
}
