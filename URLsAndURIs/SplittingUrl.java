import java.net.MalformedURLException;
import java.net.URL;

public class SplittingUrl {
    public static void main(String[] args) {
        String urlString = args[0];
        try{
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);
            System.out.println("URL: " + url);
            System.out.println("Scheme/Protocol: " + url.getProtocol());
            System.out.println(
                "User Info: " + 
                (url.getUserInfo() == 
                null ? "User not found." : url.getUserInfo()));
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + 
            (url.getPort() == -1 ? "Default" : url.getPort()));
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Reference(fragment): " + url.getRef());
        }catch(MalformedURLException malformedURLException){
            System.out.println(malformedURLException.getMessage());
        }
    }
}
