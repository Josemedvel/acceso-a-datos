package ut1.texto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraBuffer {
    public static void main(String[] args) {
        try {
            var bw = new BufferedWriter(new FileWriter("salida_texto.txt"));
            for(int i = 0; i < 100; i++){
                bw.write(""+i+"\t");
            }
            bw.close(); // acordémonos de que close hace el flush internamente
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
