package contadorpalabras;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class contadorPalabras {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);  //inicializamos input y buffered
        BufferedReader br = new BufferedReader(isr);
        String linea = null;
        int contadorPalabras = 0;  //inicializamos en 0 para ir leyendo
        try {
            while ((linea = br.readLine()) != null) {  //vamos leyendo linea a linea
                linea = linea.trim();
                if (!linea.isEmpty()) { //si existe se añade al contador de palabras
                    String[] palabras = linea.split("\\s+");
                    contadorPalabras += palabras.length;
                }
            }
            System.out.println("Número total de palabras: " + contadorPalabras);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

