import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SelectorDemoClient {
    public static void main(String[] args) {
        String message = "This is a demo String"; // This matches the server's demoText

        try {
            // Connect to the server
            SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 5454));

            // Send the message to the server
            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            client.write(buffer);

            // Prepare to read server's response (if any)
            buffer.clear();
            int bytesRead = client.read(buffer);

            if (bytesRead > 0) {
                buffer.flip();
                System.out.println("Response from server: " + new String(buffer.array(), 0, bytesRead).trim());
            } else {
                System.out.println("No response from server or connection closed.");
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

