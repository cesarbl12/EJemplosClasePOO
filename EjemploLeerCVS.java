import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploLeerCVS {
    public static void main(String[] args) {
        EjemploLeerCVS.leer();

    }

    public static void leer(){
        try {int c = 0;
            String linea;
            BufferedReader leer = new BufferedReader(new FileReader("C:/Users/cesar/OneDrive/Escritorio/Sample.Data.v3/Sample Data v3/Catalog_v2.csv"));

            while((linea = leer.readLine()) != null && c<50){
                String [] contenido = linea.split(",");
                //if (contenido [1].equals("Wii"))
                //   System.out.println("Nombre del juego y plataforma" + contenido[0]+":"+contenido[1]);
                System.out.println(linea);
                 c++;
            }
            leer.close();
        } catch (FileNotFoundException ex){
            System.err.println("No encontro el archivo");
        } catch (IOException ex){
            System.err.println("No puedo leer");
        }
    }
}
