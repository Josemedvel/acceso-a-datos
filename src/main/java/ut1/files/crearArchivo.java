package ut1.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class crearArchivo {
    public static void main(String[] args) {
        Path rutaFiles = Path.of("src", "main", "java", "ut1", "files");
        if(Files.notExists(rutaFiles.resolve("hola"))){
            try {
                Files.createFile(rutaFiles.resolve("hola.txt")); // tenemos que volverlo a poner, porque la ruta no se había modificado
                System.out.println("Archivo creado!");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
