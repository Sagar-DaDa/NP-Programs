import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ToURIMethod {
    public static void main(String[] args) {
        try{
            @SuppressWarnings("deprecation")
            URL url = new URL("http://www.example.com/index.html");
            URI uri = url.toURI();
            String urlString = url.toExternalForm();

            System.out.println("URI: " + uri);
            System.out.println("URL String: " + urlString);
        }catch(MalformedURLException | URISyntaxException malformedURLException){
            System.err.println(malformedURLException);
        }
    }
}
