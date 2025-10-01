package lectortexto;

import java.io.*;

public class lectorTexto {
    public static void main(String[] args) {
        try {
            // Usar getResourceAsStream para leer desde resources
            InputStream is = lectorTexto.class.getClassLoader().getResourceAsStream("archivo.txt");

            if (is == null) {
                throw new FileNotFoundException("No se encontró archivo.txt en resources");
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
