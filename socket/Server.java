package socket;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Porta su cui il server ascolta

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server avviato e in ascolto sulla porta " + port);

            while (true) {
                // Accetta connessioni dai client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuova connessione accettata: " + clientSocket.getInetAddress());

                // Crea uno stream di output per inviare dati al client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                // Crea uno stream di input per ricevere dati dal client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));

                // Invia un messaggio di benvenuto al client
                out.println("Benvenuto sul server!");

                // Legge il messaggio del client
                String clientMessage = in.readLine();
                System.out.println("Messaggio ricevuto dal client: " + clientMessage);
                System.out.println(System.out.charset().name());

                // Chiude la connessione
                clientSocket.close();
            }

        } catch (IOException e) {
            System.err.println("Errore nel server: " + e.getMessage());
        }
    }
}