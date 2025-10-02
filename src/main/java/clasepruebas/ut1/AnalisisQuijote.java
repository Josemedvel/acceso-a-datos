package clasepruebas.ut1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class AnalisisQuijote {
    public static void main(String[] args) {
        Path rutaLibro = Path.of("quijote.txt");
        BufferedReader br = null;
        try {
            //String libro = Files.readString(rutaLibro);
            //System.out.println(libro);
            br = new BufferedReader(new FileReader(rutaLibro.toFile()));
            String linea = "";
            String libro = "";
            while((linea=br.readLine()) != null){
                libro += linea + System.lineSeparator();
            }
            // aplicar case
            libro = libro.toUpperCase();
            libro = libro.replaceAll("\\s+", " ");
            libro = libro.replaceAll("[^\\p{L}\\s]", "");
            //System.out.println(libro);
            String [] array = libro.split(" ");
            for(String p: array){
                System.out.println(p);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
