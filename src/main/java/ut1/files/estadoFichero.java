package ut1.files;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class estadoFichero {
    public static void main(String[] args){
        Path hola = Path.of("src", "main", "java", "ut1", "files", "hola.txt");
        try {
            if (Files.exists(hola) && Files.isRegularFile(hola)) {
                System.out.println("Tamaño en bytes : " + Files.size(hola));
                System.out.println("Propietario del archivo : " + Files.getOwner(hola));
                System.out.println("Escribible : " + Files.isWritable(hola));
                System.out.println("Legible : " + Files.isReadable(hola));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
