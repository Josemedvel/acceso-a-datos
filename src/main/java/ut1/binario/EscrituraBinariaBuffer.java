package ut1.binario;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

public class EscrituraBinariaBuffer {
    public static void main(String[] args) throws Exception{
        DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("salida_escritura_binaria.txt")));
        for(int i = 0; i < 1000; i++){
            ds.writeInt(i);
        }
        ds.close();
    }
}
