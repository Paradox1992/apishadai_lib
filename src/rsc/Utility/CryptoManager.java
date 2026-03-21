package rsc.Utility;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import static rsc.Utility.UtilApi.UTL;

public final class CryptoManager {

    private static final String SECRET_PASSWORD = """
                                                  MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALLlwUkWwIKyttXE
                                                  8AQl0LtXmC24X2q3Xc5QYTe0/1muAbfHRukohJadzffE0jM4jqMV2GAs7/BC9ZlL
                                                  eubvf0hhMDOxWmm3sfTKzpXLoB69/DBy4Bzk3+fiaz3ScPbEaKqhZS1xETKlurYJ
                                                  lK4qO9DLW+ICNj2NcSDMJB+CL9oTAgMBAAECgYEAoFf1qgDOg1aTMX7WcaFDOOcF
                                                  6tS6EPhRB75bpIaB6Gth9sqR8CD01dqS5WRv0qD6l4nY6jrcw8gAQWm5uosm1MPK
                                                  VSIx4IT5i4kOd9PcEMZ8eIF8YzsDa10jq8Ya2Cf0cpEU53SF31MlMXDiHIY+q9EE
                                                  j/1pfVDpxAIm9V/nSMECQQDptbHVyjkUMzBZJP27jMwFkoJqol+cGvqef5nGsNO9
                                                  +LmJSDixyeuMEM9zagiJjq3X8LNwYzQlvE7fpLblziqLAkEAw/XAt8cyKQnccAPb
                                                  YME2SzndvLN+mUMctv+P/ZD4qzWDfOBx0it0qj+puERaqk19z81KAAuToul2gb53
                                                  CF/nmQJAHod2mJfXBvV83lg/sO0+hYfS830Mgkbf8C549wSIVGuWSQGfLlJTK7PS
                                                  daAnR1jVCr1No2PCHx/PKdXJcpGQ6wJARWGpzmf01prrNa3n6qX+NzxRyhIzbMha
                                                  TmDF9p1xrgzQdVJyeltwfybzTI7HGy08smqZHNL8ft3yW5W4R3rNYQJBAIMsorUw
                                                  nUDegXO9gm4w/g2IaNBD+oNEiYxocek7rhErRwvCAQ1e3TX0cqPkkJD8uzfgT0q8
                                                  Z/7lwVK3iFLfCs4=""";
    private static final String SALT = "6a6b3ad844e9c42eca2483556dae9c51";
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String KEY_FACTORY = "PBKDF2WithHmacSHA256";
    private static final byte[] IV_BYTES = {
        0x41, 0x70, 0x70, 0x43,
        0x6F, 0x6E, 0x66, 0x69,
        0x67, 0x49, 0x56, 0x31,
        0x36, 0x42, 0x79, 0x74
    };

    private static CryptoManager instance;

    private CryptoManager() {
    }

    public static CryptoManager getInstance() {
        if (instance == null) {
            instance = new CryptoManager();
        }
        return instance;
    }

    public String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, buildKey(), buildIv());
            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            UTL.logService().logError("CryptoManager:encrypt", e);
            return null;
        }

    }

    public String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, buildKey(), buildIv());
            byte[] decoded = Base64.getDecoder().decode(encryptedText);
            return new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
        } catch (Exception e) {
            UTL.logService().logError("CryptoManager:decrypt", e);
            return null;
        }
    }

    private SecretKey buildKey() throws Exception {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_FACTORY);
            KeySpec spec = new PBEKeySpec(
                    SECRET_PASSWORD.toCharArray(),
                    SALT.getBytes(StandardCharsets.UTF_8),
                    65536,
                    256
            );
            return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            UTL.logService().logError("CryptoManager:buildKey", e);
            return null;
        }
    }

    private IvParameterSpec buildIv() {
        return new IvParameterSpec(IV_BYTES);
    }
}
