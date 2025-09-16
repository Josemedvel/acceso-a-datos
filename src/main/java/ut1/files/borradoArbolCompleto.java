package ut1.files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Stream;

public class borradoArbolCompleto {

    public static void borrarDirectorio(Path path) {
        if (path == null) {
            return;
        }
        if (!Files.exists(path)) {
            return;
        }
        Stream<Path> stream = null;
        try {
            stream = Files.walk(path);
            stream
                    .sorted(Comparator.reverseOrder())
                    .forEach(p -> {
                        try {
                            Files.deleteIfExists(p);
                            System.out.println("Borrado: " + p);
                        } catch (IOException e) {
                            System.err.println("No se pudo borrar: " + p + " -> " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.err.println("Error al recorrer el directorio: " + path);
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (Exception ex) {
                    System.err.println("Error cerrando el stream: " + ex.getMessage());
                }
            }
        }
    }



    public static void main(String[] args) {
        Path raiz = Path.of("src", "main", "java", "ut1", "files", "CarpetaTest");
        if(Files.exists(raiz) && Files.isDirectory(raiz)){
            borrarDirectorio(raiz);
        }
    }
}
