import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIDemoRemoteImpl extends UnicastRemoteObject implements RMIDemoRemoteInterface {
    protected RMIDemoRemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public String sendMessage() throws RemoteException {
        return "Hello, BCA 6th!!!";
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a+b;
    }
}
