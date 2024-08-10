import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIDemoRemoteInterface extends Remote{
    public String sendMessage() throws RemoteException;
    public int sum(int a, int b) throws RemoteException;
}
