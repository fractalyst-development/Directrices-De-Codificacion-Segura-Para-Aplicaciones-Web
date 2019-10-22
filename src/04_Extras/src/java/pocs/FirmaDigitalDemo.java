package pocs;

import java.security.Signature;
import java.security.SignatureException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.List;
import sun.misc.*;

public class FirmaDigitalDemo {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Uso: java FirmaDigitalDemo \"texto a firmar\"");
            //System.exit(1);
            args = new String[1];
            args[0] = "Hola Mundo";
            System.out.println("Mensaje por defecto");
            System.out.println("Generando un par RSA...");
            KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
            generador.initialize(1024);
            KeyPair parClaves = generador.genKeyPair();
            System.out.println("Generando el par de claves.");
// Tomar los bytes de datos a firmar del primer argumento
            byte[] datos = args[0].getBytes("UTF8");
// Obtener instancia del objeto Signature e inicializarlo con
// la clave privada para firmarlo
            List<Provider> providers = Arrays.asList(Security.getProviders());
            System.out.println(" Security.getProviders():\n ");
            providers.stream().forEach(p->System.out.println(""+p.getName()));
            Signature firma = Signature.getInstance("MD5withRSA"); //paso 1
            firma.initSign(parClaves.getPrivate());//paso 2
// Prepara la firma de los datos
            firma.update(datos); //paso 3
// Firmar los datos
            byte[] bytesFirma = firma.sign(); //paso 4
// Mostrar en ASCII
            System.out.println("\nFirma:\n" + new BASE64Encoder().encode(bytesFirma));
// Ahora procedemos a verificar la firma. Para ello necesitaremos
// reinicializar el objeto Signature con la clave pública.
// Esto hace un reset de los datos de la firma con lo que hay que
// pasárselos de nuevo para hacer el update.
            firma.initVerify(parClaves.getPublic());//paso 5
// Pasar los datos que fueron firmados
            firma.update(datos);//paso 6
// Verificar
            boolean verificado = false;
            try {
                verificado = firma.verify(bytesFirma);//paso 7
            } catch (SignatureException se) {
                verificado = false;
            }
            if (verificado) {
                System.out.println("\nFirma verificada.");
            } else {
                System.out.println("\nFirma incorrecta.");
            }
        }
    }
}
