import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ContadorPalabras {

    public static void main(String[] args) {
        // Llamar al método para contar palabras y escribir el resultado en un archivo
        contarPalabras("C:/Users/cesar/OneDrive/Escritorio/Sample.Data.v3/Sample Data v3/annual-enterprise-survey-2023-financial-year-provisional.csv");
    }

    public static void contarPalabras(String rutaArchivo) {
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();
        
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            while ((linea = lector.readLine()) != null) {
                // Convertir la línea a minúsculas y dividirla en palabras
                String[] palabras = linea.toLowerCase().split("\\W+"); // \\W+ para separar por caracteres no alfanuméricos
                
                // Contar la frecuencia de cada palabra (que tenga más de un carácter y no sea un número)
                for (String palabra : palabras) {
                    if (!palabra.isEmpty() && palabra.length() > 1 && !palabra.matches("\\d+")) { // Evitar letras sueltas y números
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
            
            // Escribir el resultado en un archivo de texto
            escribirFrecuenciaEnArchivo(frecuenciaPalabras, "frecuencia_palabras.txt");
            
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    private static void escribirFrecuenciaEnArchivo(Map<String, Integer> frecuenciaPalabras, String nombreArchivo) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write("Palabra\t\tFrecuencia\n");
            escritor.write("--------------------------\n");
            
            for (Map.Entry<String, Integer> entrada : frecuenciaPalabras.entrySet()) {
                escritor.write(entrada.getKey() + "\t\t" + entrada.getValue() + "\n");
            }
            
            System.out.println("El archivo de frecuencia de palabras se ha creado exitosamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
}
