package ut1.texto;

import java.io.FileWriter;
import java.io.IOException;

public class EscrituraTexto {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("salida_texto.txt");
            fw.write("Hola buenas");
            fw.close(); // si no cerramos el archivo se mantiene abierto
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
