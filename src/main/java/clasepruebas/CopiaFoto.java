package clasepruebas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopiaFoto {
    public static void main(String[] args){
        DataInputStream is = null;
        DataOutputStream os = null;
        Path rutaEntrada = null;
        Path rutaSalida = null;
        try{
            rutaEntrada = Paths.get("src", "main", "java", "clasepruebas", "gato_enfadado.jpg");
            rutaSalida = rutaEntrada.resolveSibling("copiaGato.jpg");
        }catch(Exception e){
            e.printStackTrace();
        }

        int numBytes = 0;

        try{
            numBytes = (int)Files.size(rutaEntrada);
            System.out.println(numBytes);
            is = new DataInputStream(new FileInputStream(rutaEntrada.toFile()));
            os = new DataOutputStream(new FileOutputStream(rutaSalida.toFile()));
            byte [] foto = new byte[numBytes];
            for(int i = 0; i < numBytes; i++){
                foto[i] = is.readByte();
            }
            System.out.println("Archivo leído completamente");
            for(int i = 0; i < numBytes; i++){
                os.writeByte(foto[i]);
            }
            System.out.println("Archivo escrito completamente");

        }catch(FileNotFoundException e){
            System.out.println("No se ha encontrado el fichero");
            e.printStackTrace();
        }catch (IOException e) {
            System.out.println("Ha habido un error de I/O");
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                is.close();
                os.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
