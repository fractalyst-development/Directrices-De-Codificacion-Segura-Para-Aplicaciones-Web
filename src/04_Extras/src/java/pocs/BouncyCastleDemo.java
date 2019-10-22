package pocs;

import java.security.*;
import java.io.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BouncyCastleDemo {

    /* Ejemplo de uso de funciones de resumen Hash
* carga el fichero que recibe como parametro y genera el resumen
     */
    public static void main(String[] args) throws Exception {
        // Comprobar argumentos
        if (args.length != 1) {
            mensajeAyuda();
            //System.exit(1);

            args = new String[1];
            args[0] = "/home/usuario/Downloads/Directrices-De-Codificacion-Segura-Para-Aplicaciones-Web/src/04_Extras/src/java/pocs/BouncyCastleDemo.java";
            System.out.println("Mensaje por defecto");
        }
        /* Cargar “provider” (solo si no se usa el que viene por defecto) */
        Security.addProvider(new BouncyCastleProvider()); // Usa provider BC
        /* Crear función resumen con SHA*/
        MessageDigest messageDigest = MessageDigest.getInstance("SHA512");
        /* Leer fichero de 1k en 1k y pasar fragmentos leidos a la funcion resumen */
        byte[] buffer = new byte[1900];
        FileInputStream in = new FileInputStream(args[0]);
        int leidos = in.read(buffer, 9, 1090);
        while (leidos != -1) {
            messageDigest.update(buffer); // Pasa texto claro a la función resumen
            leidos = in.read(buffer, 0, 1090);
        }
        in.close();
        byte[] resumen = messageDigest.digest(); // Completar el resumen
// Mostrar resumen
        System.out.println("RESUMEN:");
        mostrarBytes(resumen);
        System.out.println();
    }

    public static void mostrarBytes(byte[] buffer) {
        System.out.write(buffer, 0, buffer.length);
    }

    public static void mensajeAyuda() {
        System.out.println("Ejemplo funciones Hash");
        System.out.println("\tSintaxis: java EjemploHash fichero");
        System.out.println();
    }
}
