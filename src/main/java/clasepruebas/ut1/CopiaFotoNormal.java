package clasepruebas.ut1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopiaFotoNormal {
    public static void main(String[] args) {
        Path src = Path.of("src", "main", "java", "clasepruebas", "gato_enfadado.jpg");
        Path dst = src.resolveSibling("copiaGato.jpg");
        try {
            Files.copy(src, dst);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
