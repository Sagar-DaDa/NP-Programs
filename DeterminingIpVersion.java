import java.net.InetAddress;
import java.net.UnknownHostException;

public class DeterminingIpVersion {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("192.168.101.10");
            System.out.println(getIpVersion(address));
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address.");
        }
    }

    private static String getIpVersion(InetAddress ipAddress) {
        byte[] address = ipAddress.getAddress();
        if (address.length == 4)
            return "The provided IP is version 4";
        else if (address.length == 16)
            return "The provided IP is version 6";
        else
            return "Invalid IP address";
    }
}



