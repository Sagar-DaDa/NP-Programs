import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CompletionHandlerDemo {
    public static void main(String[] args) throws Exception {
        writeFile();
    }

    private static void writeFile() throws IOException {
        String input = "Hello, this message is from CompletionHandlerDemo.";
        System.out.println("Input string: " + input);
        byte[] byteArray = input.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);
        Path path = Paths.get("testfile.txt");

        // Open the AsynchronousFileChannel
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        // Create and define the CompletionHandler
        CompletionHandler<Integer, String> handler = new CompletionHandler<>() {
            @Override
            public void completed(Integer result, String attachment) {
                System.out.println(attachment + " completed and " + result + " bytes are written.");
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println(attachment + " failed with exception:");
                exc.printStackTrace();
            }
        };

        // Write data to the file asynchronously
        channel.write(buffer, 0, "Async Task", handler);

        // Close the channel after the write operation is complete
        channel.close();

        // Print the file contents to verify
        printFileContents(path.toString());
    }

    private static void printFileContents(String path) throws IOException {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {

            String textRead;
            System.out.println("File contents:");
            while ((textRead = br.readLine()) != null) {
                System.out.println(textRead);
            }
        }
    }
}

