package clasepruebas.ut1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;

public class LogFechaHora {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(
                    new FileWriter(
                            Path.of("src","main", "java", "clasepruebas", "log.txt")
                                    .toFile(), true) );
            Instant ahora = Instant.now();
            bw.write(ahora.toString()); // System.lineSeparator()
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
