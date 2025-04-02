import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        String demoText = "This is a demo String";

        // Open a selector
        Selector selector = Selector.open();

        // Open and configure the server socket channel
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("localhost", 5454));
        serverSocket.configureBlocking(false);

        // Register the server socket channel with the selector
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(256);

        // Print server running message
        System.out.println("Server is running and waiting for connections...");

        while (true) {
            // Select keys that are ready for I/O operations
            selector.select();

            // Get the set of selected keys
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectedKeys.iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();
                iter.remove();

                if (key.isAcceptable()) {
                    // Accept a new client connection
                    SocketChannel client = serverSocket.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // Read data from the client
                    SocketChannel client = (SocketChannel) key.channel();
                    buffer.clear();
                    int bytesRead = client.read(buffer);

                    if (bytesRead == -1) {
                        client.close();
                        continue;
                    }

                    buffer.flip();
                    String receivedText = new String(buffer.array(), 0, bytesRead).trim();

                    if (receivedText.equals(demoText)) {
                        client.close();
                        System.out.println("Not accepting client messages anymore");
                    } else {
                        // Echo the data back to the client
                        client.write(buffer);
                    }
                }
            }
        }
    }
}

