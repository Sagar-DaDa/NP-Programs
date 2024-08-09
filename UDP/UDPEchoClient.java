package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPEchoClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // Create a DatagramSocket
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Replace with server address
            int serverPort = 2000; // Replace with server port
            
            while (true) {
                // Read user input
                System.out.print("Enter message to send: ");
                String message = scanner.nextLine();
                
                // Send the message to the server
                byte[] data = message.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
                socket.send(packet);
                
                // Prepare a DatagramPacket to receive the echo response
                byte[] buffer = new byte[256];
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);
                
                // Print the received response
                String receivedMessage = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("Received echo: " + receivedMessage);
                
                // Optionally exit on specific input
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            scanner.close();
        }
    }
}

