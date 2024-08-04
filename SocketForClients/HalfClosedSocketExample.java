package SocketForClients;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class HalfClosedSocketExample {
    public static void main(String[] args) {
        try (Socket connection = new Socket("www.oreilly.com", 80)) {
            Writer out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");
            out.write("GET / HTTP/1.0\r\n\r\n");
            out.flush();

            // Shutdown output because no more data needs to be sent
            connection.shutdownOutput();

            // Check if input and output are shutdown
            if (connection.isInputShutdown()) {
                System.out.println("Input is shutdown");
            }

            if (connection.isOutputShutdown()) {
                System.out.println("Output is shutdown");
            }

            // Close the socket when done
            connection.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
