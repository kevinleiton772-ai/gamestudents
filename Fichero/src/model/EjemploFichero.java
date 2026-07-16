
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class EjemploFichero {
    public static void main(String[] args) {
        try {
            FileWriter writer=new FileWriter("Kevin Leiton.txt");
            writer.write("Hola Mundo Ficehro");
            writer.close();
//            
            FileReader reader=new FileReader("mi archivo.txt");
            BufferedReader bufferedReader=new BufferedReader(reader);
            String linea;
            while((linea=bufferedReader.readLine())!=null){
                System.out.println(linea);
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al manejar el fichero"+e.getMessage());
        }
    }
    
}
