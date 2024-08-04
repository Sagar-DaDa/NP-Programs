import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

public class RetrieveCookieInformation {
    public static void main(String[] args) {
         // Set the default CookieManager
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        try {
            // Specify the URL to connect to
            String urlString = "http://google.com";
            URI uri = new URI(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code to ensure the request is made
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Get the cookies from the CookieStore
            List<HttpCookie> cookies = cookieManager.getCookieStore().get(uri);

            // Print the cookies
            for (HttpCookie cookie : cookies) {
                System.out.println("Cookie: " + cookie);
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
