package ClienteTCP.clase;

import java.io.*;
import java.net.Socket;

public class Cliente {

    private static final int PUERTO = 8080;
    private static final String IP = "Localhost";

    public static String enviarRegistro(String nombre, String tipoTimbrado) throws IOException {
        Socket Cliente = new Socket(IP, PUERTO);
        InputStream input = Cliente.getInputStream();
        OutputStream output = Cliente.getOutputStream();

        // Enviar datos al servidor
        DataOutputStream dataOutputStream = new DataOutputStream(output);
        dataOutputStream.writeUTF(nombre);
        dataOutputStream.writeUTF(tipoTimbrado);

        // Leer respuesta del servidor
        DataInputStream dataInputStream = new DataInputStream(input);
        String respuesta = dataInputStream.readUTF();
        System.out.println(respuesta);
        Cliente.close();
        return respuesta;

    }

    public static String formatearNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) return nombre;

        nombre = nombre.trim();
        String[] palabras = nombre.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (palabra.length() > 0) {
                resultado.append(Character.toUpperCase(palabra.charAt(0))); // Primera letra en mayúscula
                if (palabra.length() > 1) {
                    resultado.append(palabra.substring(1).toLowerCase()); // El resto en minúscula
                }
                resultado.append(" ");
            }
        }

        return resultado.toString().trim();
    }
}
