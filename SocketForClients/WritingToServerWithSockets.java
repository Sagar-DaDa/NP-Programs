package SocketForClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WritingToServerWithSockets {
    public static void main(String[] args) {
        String hostname = "dict.org"; // Example DICT server hostname
        int port = 2628;              // DICT server port
        String command = "DEFINE wn gold\r\n"; // DICT command

        try {
            // Connect to the DICT server
            Socket socket = new Socket(hostname, port);

            // Get the socket's input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send the DICT command to the server
            writer.print(command);
            writer.flush();

            // Read and print the server's response
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the resources
            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Error - " + e);
        }
    }
}
