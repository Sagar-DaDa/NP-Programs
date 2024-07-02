import java.io.IOException;
import java.net.*;

public class InetAddressDemoOne {

    public static void main(String[] args) {
        try {
            //Printing IP address using hostname.
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println(address);

            //Printing hostname using IP address.
            InetAddress host = InetAddress.getByName("142.250.205.228");
            System.out.println(host);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}





