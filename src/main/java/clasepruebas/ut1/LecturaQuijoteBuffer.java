package clasepruebas.ut1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class LecturaQuijoteBuffer {
    public static void main(String[] args) {
        Path rutaQuijote = Path.of("quijote.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new PrintWriter(System.out));
            br = new BufferedReader(new FileReader(rutaQuijote.toFile(), StandardCharsets.UTF_8));
            String linea = "";
            while((linea = br.readLine()) != null) {
                bw.write(linea+"\n");
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se ha encontrado!");
            e.printStackTrace();
        } catch(IOException e){
            System.out.println("Error al leer!");
            e.printStackTrace();
        } finally{
            try {
                br.close();
                bw.close();
            }catch(IOException e){
                System.out.println("Error al cerrar el fichero!");
                e.printStackTrace();
            }
        }
    }
}
