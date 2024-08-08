import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureObject {
    public static void main(String[] args) throws Exception {
        readFile();
    }

    private static void readFile() throws IOException, InterruptedException, ExecutionException {
        String filePath = "testfile.txt";
        printFileContents(filePath);

        Path path = Paths.get(filePath);
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(400);

        // Read the file asynchronously
        Future<Integer> result = channel.read(buffer, 0); // position = 0

        // Wait for the read operation to complete
        while (!result.isDone()) {
            System.out.println("Task of reading file asynchronously is in progress.");
            Thread.sleep(100); // Sleep for a bit before checking again
        }

        // Check if the read operation is complete
        System.out.println("Reading done: " + result.isDone());
        System.out.println("Bytes read from file: " + result.get());

        // Process the buffer contents
        buffer.flip();
        System.out.print("Buffer contents: ");
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        System.out.println();

        // Close the channel
        channel.close();
    }

    private static void printFileContents(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String textRead = br.readLine();

        System.out.println("File contents:");
        while (textRead != null) {
            System.out.println(textRead);
            textRead = br.readLine();
        }

        fr.close();
        br.close();
    }
}
