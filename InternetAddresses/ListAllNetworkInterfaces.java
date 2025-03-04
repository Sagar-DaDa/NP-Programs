import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ListAllNetworkInterfaces {
    public static void main(String[] args) {
        try{
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println(networkInterface);
            }
        }catch(SocketException socketException){
            socketException.printStackTrace();
        }
    }
}
