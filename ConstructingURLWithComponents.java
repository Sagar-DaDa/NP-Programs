import java.net.MalformedURLException;
import java.net.URL;

public class ConstructingURLWithComponents {
    public static void main(String[] args) {
        String protocol = "https";
        String hostname = "www.example.com";
        String file = "/np-unit1.pdf";

        try{
            URL fullUrl = new URL(protocol, hostname, file);
            System.out.println("URL: " + fullUrl.toString());
            System.out.println("Protocol: " + fullUrl.getProtocol());
            System.out.println("Hostname: " + fullUrl.getHost());
            System.out.println("Port: " + fullUrl.getPort());
            System.out.println("File: " + fullUrl.getFile());
        }catch(MalformedURLException malformedURLException){
            System.err.println(malformedURLException);
        }
    }
}

