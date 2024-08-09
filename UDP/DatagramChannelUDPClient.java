package UDP;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class DatagramChannelUDPClient {
    public static void main(String[] args) {
        try {
            // Open a DatagramChannel
            DatagramChannel channel = DatagramChannel.open();
            
            // Server address
            InetSocketAddress serverAddress = new InetSocketAddress("localhost", 2000);
            
            // Create a buffer for sending data
            ByteBuffer buffer = ByteBuffer.allocate(256);
            
            // Create a buffer for receiving data
            ByteBuffer responseBuffer = ByteBuffer.allocate(256);
            
            // Scanner for user input
            Scanner scanner = new Scanner(System.in);
            
            // Loop to send and receive messages
            while (true) {
                System.out.print("Enter message to send: ");
                String message = scanner.nextLine();
                
                // Clear the buffer and put the message data into it
                buffer.clear();
                buffer.put(message.getBytes());
                buffer.flip();
                
                // Send the message to the server
                channel.send(buffer, serverAddress);
                
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                
                // Receive response from the server
                responseBuffer.clear();
                channel.receive(responseBuffer);
                responseBuffer.flip();
                byte[] data = new byte[responseBuffer.remaining()];
                responseBuffer.get(data);
                String response = new String(data);
                
                // Print the response
                System.out.println("Server response: " + response);
            }
            
            // Close the channel and scanner
            channel.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

