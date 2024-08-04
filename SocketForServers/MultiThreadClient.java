package SocketForServers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MultiThreadClient {
    public static final String SERVER_ADDRESS = "localhost"; // Server address
    public static final int PORT = 13; // Port number used by the server

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT); // Connect to the server
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) { // Create a reader for the input stream

            // Read and print the server response
            String response = in.readLine();
            System.out.println("Server response: " + response);
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
