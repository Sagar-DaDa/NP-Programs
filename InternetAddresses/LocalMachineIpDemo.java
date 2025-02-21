import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalMachineIpDemo {
    public static void main(String[] args) {
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("IP address of this machine is: " + localAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}


