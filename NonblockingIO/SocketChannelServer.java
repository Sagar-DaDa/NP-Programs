import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class SocketChannelServer {
    public static void main(String[] args) throws IOException {
        // Initialize the server socket channel
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        System.out.println("Server is running on port 9000.");
        
        // Accept a connection from the client
        SocketChannel client = serverSocket.accept();
        System.out.println("Connection Set: " + client.getRemoteAddress());

        // Path to save the received file
        Path path = Paths.get(System.getProperty("user.home"), "Documents", "received_file.txt");

        // Open a file channel to write to the file
        FileChannel fileChannel = FileChannel.open(path, 
            EnumSet.of(StandardOpenOption.CREATE, 
                       StandardOpenOption.TRUNCATE_EXISTING, 
                       StandardOpenOption.WRITE)
        );

        // Buffer to read data from the client
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // Read data from the client and write it to the file
        while (client.read(buffer) > 0) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        // Close the file and client connection
        fileChannel.close();
        client.close();
        serverSocket.close();

        System.out.println("File Received");
    }
}
