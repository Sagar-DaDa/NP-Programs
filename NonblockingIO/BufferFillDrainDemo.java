package NonblockingIO;

import java.nio.CharBuffer;

public class BufferFillDrainDemo {
    private static int index = 0;
    private static String[] strings = {
        "Some random string content 1",
        "Some random string content 2",
        "Some random string content 3",
        "Some random string content 4",
        "Some random string content 5",  
        "Some random string content 6",
    };
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(100);

        while (fillBuffer(buffer)) {
            buffer.flip();     // Prepare buffer for reading
            drainBuffer(buffer); // Read and print buffer contents
            buffer.clear();    // Reset buffer for next use
        }
    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println();
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strings.length) {
            return false;
        }

        String string = strings[index++];
        for (char c : string.toCharArray()) {
            buffer.put(c);
        }

        return true;
    }

    
}

