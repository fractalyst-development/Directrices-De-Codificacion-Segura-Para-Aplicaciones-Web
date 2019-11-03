package c05_autenticacion;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author cazucito
 */
public class PBKDF2PwdSimple {

    public static void main(String[] args) {
        String passwordToHash = "Bond007d";
        String passwordToHashSalt = "20000000000000000000000000000003";
        String generatedPassword = null;
        byte[] hashwd = pbkdf2(passwordToHash.toCharArray(), passwordToHashSalt.getBytes(), 1000, 512);
        System.out.println(hashwd.toString());
    }

    static byte[] pbkdf2(final char[] password, final byte[] salt, final int iterationCount, final int keyLength) {
        try {
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
                    .generateSecret(new PBEKeySpec(password, salt, iterationCount, keyLength))
                    .getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
