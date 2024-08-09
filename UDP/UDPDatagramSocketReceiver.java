package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDatagramSocketReceiver {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Create a DatagramSocket and bind it to port 2000
            socket = new DatagramSocket(2000);
            System.out.println("Receiver is listening on port 2000...");
            
            // Prepare a DatagramPacket to receive data
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            // Receive a packet
            socket.receive(packet);
            
            // Process the received data
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message received: " + receivedMessage);
            
            // Optionally send a response
            String responseMessage = "Acknowledged: " + receivedMessage;
            byte[] responseData = responseMessage.getBytes();
            InetAddress senderAddress = packet.getAddress();
            int senderPort = packet.getPort();
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, senderAddress, senderPort);
            socket.send(responsePacket);
            System.out.println("Response sent: " + responseMessage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}

