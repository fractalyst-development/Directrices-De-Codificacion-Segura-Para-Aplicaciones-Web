package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class GestorZip {

    public void descomprimir(String ficheroZip, String directorioSalida) throws Exception {
        final int TAM_BUFFER = 4096;
        byte[] buffer = new byte[TAM_BUFFER];

        ZipInputStream flujo = null;
        try {
            flujo = new ZipInputStream(new BufferedInputStream(new FileInputStream(ficheroZip)));
            ZipEntry entrada;
            while ((entrada = flujo.getNextEntry()) != null) {
                String nombreSalida = directorioSalida + File.separator + entrada.getName();
                System.out.println("nombreSalida:"+nombreSalida);
                if (entrada.isDirectory()) {
                    File directorio = new File(nombreSalida);
                    directorio.mkdir();
                } else {
                    BufferedOutputStream salida = null;
                    try {
                        int leido;
                        salida = new BufferedOutputStream(new FileOutputStream(nombreSalida), TAM_BUFFER);
                        while ((leido = flujo.read(buffer, 0, TAM_BUFFER)) != -1) {
                            salida.write(buffer, 0, leido);
                        }

                        if(nombreSalida.endsWith("zip")) {
                            Path p = Paths.get(nombreSalida);
                           System.out.println("p.toString():"+p.toString());                         
                           System.out.println("p.getParent().toString():"+p.getParent().toString());                         
                            descomprimir(p.toString(), p.getParent().toString());
                        }
                    } finally {
                        if (salida != null) {
                            salida.close();
                        }
                    }
                }
            }
        } finally {
            if (flujo != null) {
                flujo.close();
            }

        }
    }
}
