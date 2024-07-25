import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class AccessingPasswordProtectedSite {

    // Authenticator subclass to provide credentials
    static class MyAuthenticator extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            String username = "admin";
            String password = "admin123x";
            return new PasswordAuthentication(username, password.toCharArray());
        }
    }
    public static void main(String[] args) {
        // Set the default authenticator
        Authenticator.setDefault(new MyAuthenticator());

        String url = "https://httpbin.org/basic-auth/admin/admin123";
        
        try {
            // Create a URL object
            URL urlObject = new URL(url);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            
            // Set the HTTP request method (GET by default)
            connection.setRequestMethod("GET");
            
            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            // Print the response
            System.out.println("Response:");
            System.out.println(response.toString());
            
            // Disconnect the connection
            connection.disconnect();
            
        } catch (IOException e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        }
    }
}
