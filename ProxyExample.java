import java.net.*;

public class ProxyExample {
    public static void main(String[] args) {
        try {
            // Creating a DIRECT proxy (no proxy)
            Proxy directProxy = Proxy.NO_PROXY;
            System.out.println("Direct connection: " + directProxy);

            // Creating an HTTP Proxy
            Proxy httpProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));
            System.out.println("HTTP Proxy: " + httpProxy);

            // Creating a SOCKS Proxy
            Proxy socksProxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("socks.example.com", 1080));
            System.out.println("SOCKS Proxy: " + socksProxy);

            // Example of using a proxy to open a URL connection
            URL url = new URL("http://something.com");
            URLConnection connection = url.openConnection(httpProxy);
            System.out.println("Using HTTP Proxy to connect to: " + url);
            connection.connect();
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
