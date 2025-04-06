package SocketForClients;

import java.io.*;
import java.net.*;

public class WhoisClient {
    public static void main(String[] args) {
        String whoisServer = "whois.arin.net";
        int port = 43;
        String query = "23.56.52.26"; // Example IP address
        
        try (Socket socket = new Socket(whoisServer, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            // Send query
            out.println(query);
            
            // Read and print response
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

