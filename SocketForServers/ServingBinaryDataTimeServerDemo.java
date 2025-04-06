package SocketForServers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Date;

public class ServingBinaryDataTimeServerDemo {
    public final static int PORT = 37;

    public static void main(String[] args) {
        // The time protocol sets the epoch at 1900,
        // the Date class at 1970. This number converts between them.
        long differenceBetweenEpochs = 2208988800L;

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started...");
            while (true) {
                System.out.println("Waiting for client request...");
                try (Socket connection = server.accept()) {
                    System.out.println("Incoming connection: ACCEPTED");
                    OutputStream out = connection.getOutputStream();
                    Date now = new Date();
                    long msSince1970 = now.getTime();
                    long secondsSince1970 = msSince1970 / 1000;
                    long secondsSince1900 = secondsSince1970 + differenceBetweenEpochs;

                    // Use ByteBuffer to convert the long value to bytes
                    byte[] time = ByteBuffer.allocate(4).putInt((int) secondsSince1900).array();

                    out.write(time);
                    out.flush();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
