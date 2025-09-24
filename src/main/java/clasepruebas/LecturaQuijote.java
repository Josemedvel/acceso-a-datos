package clasepruebas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class LecturaQuijote {
    public static void leerLibro(FileReader fr, ArrayList<String> libro){
        String linea = "";
        int c = 0;
        while(c != -1){
            try {
                c = fr.read();
                if((char)c == '\n'){
                    libro.add(linea);
                    linea = "";
                }else{
                    linea += (char)c;
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> libro = new ArrayList<>();
        Path rutaQuijote = Path.of("quijote.txt");
        FileReader fr = null;
        try{
            fr = new FileReader(rutaQuijote.toFile());
            leerLibro(fr, libro);
            System.out.println(libro.size());
            System.out.println(libro.get(5));
        }catch(FileNotFoundException e){
            System.out.println("El archivo no se ha encontrado!");
            e.printStackTrace();
        }finally {
            try {
                if(fr != null){
                    fr.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
