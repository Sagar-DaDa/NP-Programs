package URLConnections;

// Demonstrate URLConnection.
import java.net.*;
import java.io.*;
import java.util.Date;

public class URLConnectionDemo {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.w3schools.com/java/default.asp");
        URLConnection connection = url.openConnection();

        // Get date
        long date = connection.getDate();
        if (date == 0)
            System.out.println("No date information.");
        else
            System.out.println("Date: " + new Date(date));

        // Get content type
        System.out.println("Content-Type: " + connection.getContentType());

        // Get expiration date
        date = connection.getExpiration();
        if (date == 0)
            System.out.println("No expiration information.");
        else
            System.out.println("Expires: " + new Date(date));

        // Get last-modified date
        date = connection.getLastModified();
        if (date == 0)
            System.out.println("No last-modified information.");
        else
            System.out.println("Last-Modified: " + new Date(date));

        // Get content length
        int length = connection.getContentLength();
        if (length == -1)
            System.out.println("Content length unavailable.");
        else
            System.out.println("Content-Length: " + length);
    }
}
