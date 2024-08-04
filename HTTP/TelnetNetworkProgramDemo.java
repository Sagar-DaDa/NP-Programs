
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * TelnetNetworkProgramDemo
 */
public class TelnetNetworkProgramDemo {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8000;

        try {
            // Create a TCP socket and connect to the host:port
            Socket socket = new Socket(host, port);
            
            // Create the input and output streams for the network socket
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            
            // Send request to the HTTP server
            printWriter.println("GET / HTTP/1.0");
            printWriter.println(); // blank line separating header & body
            printWriter.flush();
            
            // Read the response and display on console
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Close the I/O streams
            bufferedReader.close();
            printWriter.close();
            socket.close();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }
    }
}
