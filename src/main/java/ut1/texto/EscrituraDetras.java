package ut1.texto;

import java.io.FileWriter;
import java.io.IOException;

public class EscrituraDetras {
    public static void main(String[] args) {
        try{
            FileWriter fw = new FileWriter("salida_texto.txt", true); // si no ponemos el booleano a true, sustituye lo que haya
            fw.append("\nOtra línea");
            fw.flush();
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
