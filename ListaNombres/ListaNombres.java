import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListaNombres {
    public static void main(String[] args) {
        String archivo = "nombres.txt";

        // Leer los nombres del archivo
        List<String> listaNombres = leerNombresDesdeArchivo(archivo);

        // Pedir nuevos nombres hasta que se introduzca "fin"
        Scanner scanner = new Scanner(System.in);
        String nombre;

        System.out.println("Introduce nombres nuevos (escribe 'fin' para terminar):");
        while (true) {
            nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            listaNombres.add(nombre);
            Collections.sort(listaNombres); // Ordenar la lista alfabéticamente
        }

        // Guardar la lista actualizada en el archivo
        guardarNombresEnArchivo(listaNombres, archivo);

        System.out.println("Lista actualizada de nombres guardada en el archivo.");
    }

    private static List<String> leerNombresDesdeArchivo(String archivo) {
        List<String> listaNombres = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String nombre;

            while ((nombre = br.readLine()) != null) {
                listaNombres.add(nombre);
            }
        } catch (IOException e) {
            // El archivo no existe o no se puede leer
        }

        return listaNombres;
    }

    private static void guardarNombresEnArchivo(List<String> listaNombres, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String nombre : listaNombres) {
                bw.write(nombre);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los nombres en el archivo: " + e.getMessage());
        }
    }
}
