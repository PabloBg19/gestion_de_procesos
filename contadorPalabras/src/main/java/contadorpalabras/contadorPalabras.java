package contadorpalabras;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class contadorPalabras {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String linea = null;
        int contadorPalabras = 0;
        try {
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
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
