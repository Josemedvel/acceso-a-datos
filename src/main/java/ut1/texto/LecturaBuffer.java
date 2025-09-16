package ut1.texto;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class LecturaBuffer {
    public static void main(String[] args) {
        try {
            var br = new BufferedReader(new FileReader("quijote.txt"));
            //br.lines().forEach(System.out::println); //si queremos usar una API más moderna de Java podemos investigar los Streams
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
