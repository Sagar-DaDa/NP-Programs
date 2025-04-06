package SocketForServers;

import java.io.InputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Date;

public class TimeServerClient {
    public final static String SERVER = "localhost"; // Replace with server IP if not running locally
    public final static int PORT = 37;

    public static void main(String[] args) {
        long differenceBetweenEpochs = 2208988800L;

        try (Socket socket = new Socket(SERVER, PORT)) {
            InputStream in = socket.getInputStream();
            byte[] time = new byte[4];

            // Read the 4-byte time data from the server
            int bytesRead = in.read(time);
            if (bytesRead != 4) {
                throw new IOException("Incomplete time data received from server.");
            }

            // Use ByteBuffer to convert the byte array to a long value
            long secondsSince1900 = ByteBuffer.wrap(time).getInt() & 0xFFFFFFFFL;

            // Convert to seconds since 1970 (Unix epoch)
            long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;

            // Convert seconds to milliseconds and create Date object
            long msSince1970 = secondsSince1970 * 1000;
            Date now = new Date(msSince1970);

            System.out.println("Server time: " + now);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
