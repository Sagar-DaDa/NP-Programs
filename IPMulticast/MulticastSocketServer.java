package IPMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSocketServer {
    private static final String INET_ADDR = "224.0.0.3";
    private static final int PORT = 8888;

    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName(INET_ADDR);
            DatagramSocket serverSocket = new DatagramSocket();

            for (int i = 0; i < 5; i++) {
                String msg = "Sent message no " + i;
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.length(), addr, PORT);
                serverSocket.send(msgPacket);
                System.out.println("Server sent: " + msg);
                Thread.sleep(500);
            }

            serverSocket.close();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

