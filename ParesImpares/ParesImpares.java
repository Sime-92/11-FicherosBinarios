import java.io.*;
import java.util.Scanner;

public class ParesImpares {
    public static void main(String[] args) {
        String archivoEntrada = "numeros.dat";
        String archivoPares = "pares.dat";
        String archivoImpares = "impares.dat";

        // Crear el archivo numeros.dat
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoEntrada))) {
            Scanner scanner = new Scanner(System.in);
            int cantidadNumeros;

            System.out.print("Ingresa la cantidad de números que quieres ");
            cantidadNumeros = scanner.nextInt();

            System.out.println("Escribe los números:");

            for (int i = 0; i < cantidadNumeros; i++) {
                int numero = scanner.nextInt();
                bw.write(Integer.toString(numero));
                bw.newLine();
            }

            System.out.println("Números guardados correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar los números en el archivo: " + e.getMessage());
            return;
        }

        // Separar los números en pares e impares
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bwPares = new BufferedWriter(new FileWriter(archivoPares));
             BufferedWriter bwImpares = new BufferedWriter(new FileWriter(archivoImpares))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                int numero = Integer.parseInt(linea);

                if (numero % 2 == 0) {
                    bwPares.write(Integer.toString(numero));
                    bwPares.newLine();
                } else {
                    bwImpares.write(Integer.toString(numero));
                    bwImpares.newLine();
                }
            }

            System.out.println("Separación de números completada.");
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en los archivos: " + e.getMessage());
        }
    }
}
