package SecureSocket;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class SSLSocketClient {
    public static void main(String[] args) {
        try {
            // Get the default SSL socket factory
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            
            // Create an SSL socket connected to the specified host and port
            SSLSocket socket = (SSLSocket) factory.createSocket("www.verisign.com", 443);
            
            // Start the SSL handshake
            socket.startHandshake();
            
            // Send an HTTP request
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("GET / HTTP/1.1");
            out.println("Host: www.verisign.com"); // Add Host header
            out.println("Connection: close"); // Close connection after request
            out.println();
            out.flush();
            
            // Check for errors
            if (out.checkError()) {
                System.out.println("SSLSocketClient: java.io.PrintWriter error");
            }
            
            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            // Close the streams and socket
            in.close();
            out.close();
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
