package ut1.binario;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EscrituraBinaria {
    public static void main (String[] args) throws Exception{
        double d1 = 3.14;
        DataOutputStream s = new DataOutputStream(new FileOutputStream("salida_escritura_binaria.txt"));
        s.writeDouble(d1);
        s.flush();
        s.close();
    }
}
