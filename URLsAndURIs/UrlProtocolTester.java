import java.net.MalformedURLException;
import java.net.URL;

public class UrlProtocolTester {
    public static void main(String[] args) {
        String urlString = args[0];
        testProtocol(urlString);
    }

    private static void testProtocol(String url){
        try{
            @SuppressWarnings("deprecation")
            URL urlObj = new URL(url);
            System.out.println("URL: " + urlObj.toString());
            System.out.println("Protocol " + urlObj.getProtocol() + " is supported.");
        }catch(MalformedURLException malformedURLException){
            String protocol = url.substring(0, url.indexOf(":"));
            System.out.println("Protocol " + protocol + " is not supported.");
        }
    }
}
