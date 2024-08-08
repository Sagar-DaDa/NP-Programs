import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SocketChannelClient {
    public static void main(String[] args) throws IOException {
        // Create a socket channel and connect to the server at localhost on port 9000
        SocketChannel client = SocketChannel.open();
        SocketAddress socketAddr = new InetSocketAddress("localhost", 9000);
        client.connect(socketAddr);

        // Path to the file to be sent
        Path path = Paths.get("testfile.txt");
        FileChannel fileChannel = FileChannel.open(path);

        // Create a buffer to read file content into
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // Read the file and send its contents through the socket channel
        while (fileChannel.read(buffer) > 0) {
            buffer.flip(); // Switch buffer from writing mode to reading mode
            client.write(buffer); // Write buffer content to the socket channel
            buffer.clear(); // Clear the buffer for the next read
        }

        // Close the file and socket channels
        fileChannel.close();
        client.close();

        System.out.println("File Sent");
    }
}
