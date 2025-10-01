package filtrarlineas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltrarLineas { // Nombre de clase ajustado a mayúscula inicial
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String linea;
        try {
            while ((linea = br.readLine()) != null) {

                if (linea.length() > 20) {
                    System.out.println(linea);
                }
            }
            br.close();
            isr.close();
        } catch (IOException e) {
            System.out.println("error al leer ");
        }
    }
}