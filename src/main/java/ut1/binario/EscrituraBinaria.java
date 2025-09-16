package ut1.binario;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class EscrituraBinaria {
    public static void main (String[] args){
        double d1 = 3.14;
        DataOutputStream s = null;
        try{
            s = new DataOutputStream(new FileOutputStream("salida_escritura_binaria.bin"));
            s.writeDouble(d1);
            s.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                s.close();
            }catch(IOException e){
                e.printStackTrace();
            }

        }

    }
}
