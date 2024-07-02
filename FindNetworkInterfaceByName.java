import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Scanner;

public class FindNetworkInterfaceByName {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter interface name to search: ");
        String interfaceName = scanner.nextLine();
        scanner.close();
        try {
            NetworkInterface networkInterface = NetworkInterface.getByName(interfaceName); //wireless_32768
            if (networkInterface == null){
                System.out.println("No such interface: " + interfaceName);
            }else{
                System.out.println("Interface name: " + networkInterface.getDisplayName());
            }
        } catch (SocketException ex) {
            System.out.println("Could not list sockets.");
        }
    }
}
