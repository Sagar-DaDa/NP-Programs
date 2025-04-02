import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestingReachability {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName(args[0]);
            System.out.println("""
                    Hostname: %s,
                    IP address: %s,
                    Status: %s
                    """.formatted(address.getHostName(), address.getHostAddress(),
                    address.isReachable(100) ? "Reachable" : "Not reachable"));
        } catch (IOException exception) {
            if (exception instanceof UnknownHostException) {
                System.out.println("UnknownHostException: Unable to resolve host.");
            } else {
                System.out.println("Something went wrong");
            }
        }
    }
}
