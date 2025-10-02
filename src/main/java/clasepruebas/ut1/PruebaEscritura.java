package clasepruebas.ut1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class PruebaEscritura {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        Scanner sc = null;
        try{
            bw = new BufferedWriter(new FileWriter(Path.of("t1.txt").toFile(), true));
            sc = new Scanner(System.in);
            System.out.print("Ingresa tu frase:");
            String linea = sc.nextLine();
            bw.write(linea);
        }catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                bw.close();
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
