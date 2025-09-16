package ut1.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class crearDirectorio {
    public static void main(String[] args) {
        Path pTest = Path.of("src", "main", "java", "ut1", "files","CarpetaTest");
        if(Files.notExists(pTest)){
            try {
                Files.createDirectory(pTest);
                System.out.println("Carpeta creada!");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("La carpeta ya existe!");
        }
    }
}
