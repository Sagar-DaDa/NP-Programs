package IPMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSocketClient {
    private static final String INET_ADDR = "224.0.0.3";
    private static final int PORT = 8888;

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName(INET_ADDR);
            byte[] buf = new byte[256];

            MulticastSocket clientSocket = new MulticastSocket(PORT);
            clientSocket.joinGroup(address);

            System.out.println("Client is waiting for server messages...");

            while (true) {
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                clientSocket.receive(msgPacket);
                String msg = new String(msgPacket.getData(), 0, msgPacket.getLength());
                System.out.println("Client received: " + msg);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

