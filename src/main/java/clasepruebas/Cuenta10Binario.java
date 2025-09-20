package clasepruebas;

import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Cuenta10Binario {
    public static void main(String[] args) {
        DataOutputStream f = null;
        try{
            f = new DataOutputStream(new FileOutputStream("salida_cuenta.bin"));
            for(int i = 0; i < 10; i++){
                f.writeInt(i+1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                f.close();
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}
