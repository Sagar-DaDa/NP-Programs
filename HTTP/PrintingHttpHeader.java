import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class PrintingHttpHeader {
    public static void main(String[] args) {
         try {
            // Specify the URL
            String urlString = "http://google.com";
            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response headers
            Map<String, List<String>> headers = connection.getHeaderFields();

            // Print the headers
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
