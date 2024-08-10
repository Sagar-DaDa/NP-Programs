import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIDemoRemoteServer {
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            RMIDemoRemoteImpl remoteObject = new RMIDemoRemoteImpl();
            
            // Start the RMI registry
            LocateRegistry.createRegistry(1099);

            // Register the remote object with the RMI registry
            Naming.rebind("RMIDemoRemoteObject", remoteObject);
            
            System.out.println("Remote object is bound and ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


