package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a DatagramSocket and bind it to port 2000
            socket = new DatagramSocket(2000);
            System.out.println("UDP Echo Server is running on port 2000...");
            
            // Prepare a DatagramPacket to receive data
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            while (true) {
                // Receive a packet
                socket.receive(packet);
                
                // Process the received data
                String receivedMessage = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + receivedMessage);
                
                // Echo the received message back to the sender
                InetAddress senderAddress = packet.getAddress();
                int senderPort = packet.getPort();
                DatagramPacket responsePacket = new DatagramPacket(
                    packet.getData(), packet.getLength(), senderAddress, senderPort);
                socket.send(responsePacket);
                System.out.println("Sent back: " + receivedMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}

