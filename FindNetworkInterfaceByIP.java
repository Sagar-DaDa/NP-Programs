import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FindNetworkInterfaceByIP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter IP address of the interface: ");
        String ipAddress = scanner.nextLine();
        scanner.close();

        try{
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);

            if (networkInterface == null) {
                System.out.println("No interface found with the IP address " + ipAddress);
            }else{
                System.out.println("Interface found.");
                System.out.println("Interface name: " + networkInterface.getDisplayName());
                System.out.println("IP address: " + ipAddress);
            }
        }catch(SocketException socketException){
            System.out.println("Could not list the network interfaces.");
        }catch(UnknownHostException unknownHostException){
            System.out.println("Could not lookup " + ipAddress);
        }
    }
}
