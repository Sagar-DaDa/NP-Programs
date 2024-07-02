import java.net.MalformedURLException;
import java.net.URL;

public class ConstructingURL {
    public static void main(String[] args) {
        try{
            URL simpleUrl = new URL("https://www.facebook.com/");
            System.out.println("URL: " + simpleUrl.toString());
            System.out.println("Protocol: " + simpleUrl.getProtocol());
            System.out.println("Hostname: " + simpleUrl.getHost());
        }catch(MalformedURLException malformedURLException){
            System.err.println(malformedURLException);
        }
    }
}
