import java.net.InetAddress;
import java.net.UnknownHostException;

public class VarifyingSameMachine {
    public static void main(String[] args) {
        try {
            InetAddress firstHost = InetAddress.getByName("www.messenger.com");
            InetAddress secondHost = InetAddress.getByName("www.m.me");

            if (firstHost.equals(secondHost)) {
                System.out.println("Provided two hosts are pointing to the same machine.");
                System.out.println("First host: " + firstHost);
                System.out.println("Second host: " + secondHost);
            } else {
                System.out.println("Provided two hosts are not pointing to the same machine.");
                System.out.println("First host: " + firstHost);
                System.out.println("Second host: " + secondHost);
            }
        } catch (UnknownHostException unknownHostException) {
            System.out.println("Host lookup failed.");
        }
    }
}


