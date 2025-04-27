package UDP;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelUDPServer {
    public static void main(String[] args) {
        try {
            // Open a DatagramChannel
            DatagramChannel channel = DatagramChannel.open();
            
            // Bind the channel to a local address
            channel.bind(new InetSocketAddress(2000));

            // Print server started message
            System.out.println("UDP Server started on port 2000...");
            
            // Create a buffer to hold incoming data
            ByteBuffer buffer = ByteBuffer.allocate(256);
            
            // Loop to receive data
            while (true) {
                buffer.clear();
                
                // Receive a packet into the buffer
                InetSocketAddress clientAddress = (InetSocketAddress) channel.receive(buffer);
                
                // Print the received message
                buffer.flip();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                String message = new String(data);
                
                System.out.println("Received message from " + clientAddress + ": " + message);
                
                // Prepare a response message
                String response = message;
                ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
                
                // Send the response to the client
                channel.send(responseBuffer, clientAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

