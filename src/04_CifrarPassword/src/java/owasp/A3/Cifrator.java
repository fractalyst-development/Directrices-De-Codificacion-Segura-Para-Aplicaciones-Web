package owasp.A3;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.digest.PooledStringDigester;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;

public class Cifrator {

    public String cifraPwd(String pwd) {
        PooledStringDigester digester = new PooledStringDigester();
        digester.setPoolSize(4);
        digester.setAlgorithm("SHA-512");
        digester.setIterations(10000);
        String digest = digester.digest(pwd);
        return digest;
    }

    public String cifraDatoSensible(String datoSensible, String pwd) {
        PooledPBEStringEncryptor cifrator = new PooledPBEStringEncryptor();
        cifrator.setProvider(new BouncyCastleProvider());
        cifrator.setPoolSize(4);
        cifrator.setPassword(pwd);
        cifrator.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
        String encryptedText = cifrator.encrypt(datoSensible);
        return encryptedText;
    }

    public String descifraDatoSensible(String textoCifrado, String pwd) {
        PooledPBEStringEncryptor cifrator = new PooledPBEStringEncryptor();
        cifrator.setProvider(new BouncyCastleProvider());
        cifrator.setPoolSize(4);
        cifrator.setPassword(pwd);
        cifrator.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
        String encryptedText = cifrator.decrypt(textoCifrado);
        return encryptedText;
    }

    public boolean comparaPwd(String pwd, String digest) {
        PooledStringDigester digester = new PooledStringDigester();
        digester.setPoolSize(4);
        digester.setAlgorithm("SHA-512");
        digester.setIterations(10000);
        return (digester.matches(pwd, digest));
    }

}
