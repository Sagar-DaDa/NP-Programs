import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheckProgram {
    public static final String SPAMHAUS = "spamhaus.org/sbl";
    public static void main(String[] args) {
        for(String suspectedAddress: args){
            if (isSpammer(suspectedAddress)) {
                System.out.println(suspectedAddress + " is a known spammer.");
            } else {
                System.out.println(suspectedAddress + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String suspectedAddress){
        try{
            InetAddress address = InetAddress.getByName(suspectedAddress);
            byte[] quadAddress = address.getAddress();
            String checkQuery = SPAMHAUS;
            for(byte octet : quadAddress){
                int reversedQuadAddress = octet < 0 ? octet + 256 : octet;
                checkQuery = reversedQuadAddress + "." + checkQuery;
            }
            InetAddress.getByName(checkQuery);
            return true;
        } catch (UnknownHostException unknownHostException){
            return false;
        }
    }
}
