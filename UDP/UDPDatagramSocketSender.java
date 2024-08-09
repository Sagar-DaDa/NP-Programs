package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDatagramSocketSender {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a DatagramSocket
            socket = new DatagramSocket();
            
            // Prepare the data to be sent
            String message = "Hello, BCA 6th!!!";
            byte[] data = message.getBytes();
            
            // Create a DatagramPacket with destination address and port
            InetAddress address = InetAddress.getByName("localhost"); // Replace with the receiver's address
            int port = 2000; // Replace with the receiver's port
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            
            // Send the packet
            socket.send(packet);
            System.out.println("Message sent: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}

