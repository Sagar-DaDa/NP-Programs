import java.net.*;
import java.io.*;

public class AllMIMEHeaders {
    public static void main(String args[]) {
        try {
            @SuppressWarnings("deprecation")
            URL u = new URL("https://www.google.com");
            URLConnection uc = u.openConnection();
            for (int j = 1; ; j++) {
                String header = uc.getHeaderField(j);
                if (header == null) break;
                System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
            }
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL.");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

