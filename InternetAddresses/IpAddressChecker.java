import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddressChecker {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName(args[0]);

            // Check if the address is a wildcard address
            if (address.isAnyLocalAddress()) {
                System.out.println(address + " is a wildcard address.");
            }

            // Check if the address is a loopback address
            if (address.isLoopbackAddress()) {
                System.out.println(address + " is loopback address.");
            }

            // Check if the address is a link-local address
            if (address.isLinkLocalAddress()) {
                System.out.println(address + " is a link-local address.");
            }
            // Check if the address is a site-local address
            else if (address.isSiteLocalAddress()) {
                System.out.println(address + " is a site-local address.");
            } 
            // If it's not any of the above, check if it is a global address
            else {
                System.out.println(address + " is a global address.");
            }

            // Check if the address is a multicast address
            if (address.isMulticastAddress()) {
                // Check if the multicast address is a global multicast address
                if (address.isMCGlobal()) {
                    System.out.println(address + " is a global multicast address.");
                }
                // Check if the multicast address is an organization-wide multicast address
                else if (address.isMCOrgLocal()) {
                    System.out.println(address + " is an organization wide multicast address.");
                } 
                // Check if the multicast address is a site-wide multicast address
                else if (address.isMCSiteLocal()) {
                    System.out.println(address + " is a site wide multicast address.");
                } 
                // Check if the multicast address is a subnet-wide multicast address
                else if (address.isMCLinkLocal()) {
                    System.out.println(address + " is a subnet wide multicast address.");
                } 
                // Check if the multicast address is an interface-local multicast address
                else if (address.isMCNodeLocal()) {
                    System.out.println(address + " is an interface-local multicast address.");
                } 
                // If it's a multicast address but doesn't fit any specific type, print unknown type
                else {
                    System.out.println(address + " is an unknown multicast address type.");
                }
            } 
            // Finally, if it is not multicast, it should be unicast
            else {
                System.out.println(address + " is a unicast address.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Could not resolver: " + args[0]);
        }
    }
}
