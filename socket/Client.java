package provasocket;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Indirizzo del server (localhost per lo stesso PC)
        int port = 7777; // Porta del server

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connessione al server " + serverAddress + ":" + port + " stabilita.");

            // Crea uno stream di output per inviare dati al server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8);

            // Crea uno stream di input per ricevere dati dal server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Legge il messaggio di benvenuto dal server
            String serverMessage = in.readLine();
            System.out.println("Messaggio dal server: " + serverMessage);

            // Invia un messaggio di presentazione al server
            out.println("Ciao, sono un nuovo client!");
            out.flush();

        } catch (IOException e) {
            System.err.println("Errore nel client: " + e.getMessage());
        }
    }
}