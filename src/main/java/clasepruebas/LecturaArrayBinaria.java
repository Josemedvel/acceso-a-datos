package clasepruebas;

import java.io.*;
import java.util.ArrayList;


public class LecturaArrayBinaria {
    public static void main(String[] args) {
        DataInputStream r = null;
        ArrayList<Integer> arr = new ArrayList<>(10);
        System.out.println(arr.size());
        try{
            r = new DataInputStream(new FileInputStream("salida_cuenta.bin"));
            while(true){
                arr.add(r.readInt());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.err.println("No existe el fichero");
        }/*catch(EOFException e) {
            System.out.println("Hemos leído tutto el fichero");
        }*/catch(IOException e){
            System.err.println("No se ha podido leer");
        }finally{
            try{
                r.close();
            }catch (IOException e){
                System.err.println("No se ha podido cerrar el fichero");
            }
            for(int i = 0; i < arr.size(); i++){
                System.out.println("Pos("+i+") : " + arr.get(i));
            }
        }
    }
}
