package SocketForClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ReadingFromServerWithSockets {
    public static void main(String[] args) {
        try {
            // Connect a socket to some host machine and port
            Socket socket = new Socket("www.facebook.com", 443);

            // Connect a buffered reader
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Connect a print stream
            PrintStream pstream = new PrintStream(socket.getOutputStream());

            // Example usage (optional): reading and writing data
            pstream.println("Hello, server!"); // send data to server
            String response = reader.readLine(); // read response from server
            System.out.println("Server response: " + response);

            // Close resources
            reader.close();
            pstream.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Error - " + e);
        }

    }
}
