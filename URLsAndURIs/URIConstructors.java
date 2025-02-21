import java.net.URI;
import java.net.URISyntaxException;

public class URIConstructors {

    public static void main(String[] args) {
        try {
            // Constructor 1: URI(String str)
            URI uri1 = new URI("https://www.example.com:8080/path?query=param#fragment");
            System.out.println("URI 1: " + uri1);

            // Constructor 2: URI(String scheme, String ssp, String fragment)
            URI uri2 = new URI("https", "//www.example.com/path", "fragment");
            System.out.println("URI 2: " + uri2);

            // Constructor 3: URI(String scheme, String userInfo, String host, int port, String path, String query, String fragment)
            URI uri3 = new URI("https", "user:password", "www.example.com", 8080, "/path", "query=param", "fragment");
            System.out.println("URI 3: " + uri3);

            // Constructor 4: URI(String scheme, String host, String path, String fragment)
            URI uri4 = new URI("https", "www.example.com", "/path", "fragment");
            System.out.println("URI 4: " + uri4);

            // Constructor 5: URI(String scheme, String authority, String path, String query, String fragment)
            URI uri5 = new URI("https", "www.example.com:8080", "/path", "query=param", "fragment");
            System.out.println("URI 5: " + uri5);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}