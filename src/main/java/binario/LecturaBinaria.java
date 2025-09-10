package binario;

// descargar dhex para modificar el valor

import java.io.DataInputStream;
import java.io.FileInputStream;

public class LecturaBinaria {
    public static void main(String[] args) throws Exception{
        var s = new DataInputStream(new FileInputStream("salida_escritura_binaria.txt"));
        int d = s.readInt();
        System.out.println(d);
    }
}
