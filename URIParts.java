import java.net.URI;
import java.net.URISyntaxException;

public class URIParts {
    public static void main(String[] args) {
        try{
            URI uri = new URI("https://www.example.com:8080/path?query=param#fragment");
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Scheme Specific Part: " + uri.getSchemeSpecificPart());
            System.out.println("Raw Scheme Specific Part: " + uri.getRawSchemeSpecificPart());
            System.out.println("Fragment: " + uri.getFragment());
            System.out.println("Raw Fragment: " + uri.getRawFragment());
        }catch(URISyntaxException uriSyntaxException){
            System.err.println(uriSyntaxException);
        }
    }
}
