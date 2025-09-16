package ut1.binario;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;

public class LecturaBinariaBuffer {
    public static void main(String[] args){
        try {
            DataInputStream ds = new DataInputStream(new BufferedInputStream(new FileInputStream("salida_escritura_binaria.txt")));
            ArrayList<Integer> array = new ArrayList<>(1000);
            for (int i = 0; i < 1000; i++) {
                array.add(i, ds.readInt());
            }
            ds.close();
            System.out.println(array);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
