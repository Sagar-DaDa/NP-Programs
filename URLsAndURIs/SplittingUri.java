import java.net.URI;
import java.net.URISyntaxException;

public class SplittingUri {
    public static void main(String[] args) {
        try{
            URI uri = new URI("https://admin:pass1234@www.example.com:8080/path/content/profile.php?q='Ram'#3hxcf");
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("User info: " + uri.getUserInfo());
            System.out.println("Authority: " + uri.getAuthority());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + (uri.getPort() == -1 ? "Default" : uri.getPort()));
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
        }catch(URISyntaxException uriSyntaxException){
            System.err.println(uriSyntaxException);
        }
    }
}
