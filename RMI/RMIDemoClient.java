import java.rmi.Naming;

public class RMIDemoClient {
    public static void main(String[] args) {
        try {
            // Look up the remote object
            RMIDemoRemoteInterface remoteObject = (RMIDemoRemoteInterface) Naming.lookup("rmi://localhost/RMIDemoRemoteObject");
            
            // Call methods on the remote object
            System.out.println(remoteObject.sendMessage());
            System.out.println("Sum: " + remoteObject.sum(5, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



