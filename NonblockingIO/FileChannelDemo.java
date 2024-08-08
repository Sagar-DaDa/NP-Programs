import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("testfile.txt", "r");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.flip(); // Prepare the buffer to read
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear(); // Clear the buffer for the next read
        }
        file.close();
    }
}

