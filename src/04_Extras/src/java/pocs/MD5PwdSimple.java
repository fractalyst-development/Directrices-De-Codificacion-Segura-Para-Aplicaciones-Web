package pocs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PwdSimple {

    public static void main(String[] args) {
        String passwordToHash = "Bond007";
        String generatedPassword = null;
        try {
            // Instancia del 
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Cadena a bytes para sacar el digest
            md.update(passwordToHash.getBytes());
            // Obtener el hash (en bytes)
            byte[] bytes = md.digest();
            // This bytes[] has bytes in decimal format;
            // El arreglo está en formato decimal
            // Convertirlo a representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Password hash en formato hexadecimal
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
    }
}