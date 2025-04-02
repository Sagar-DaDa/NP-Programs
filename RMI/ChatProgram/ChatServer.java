import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Queue;

public class ChatServer extends UnicastRemoteObject implements Chat {
    private Queue<String> messages;

    protected ChatServer() throws RemoteException {
        messages = new LinkedList<>();
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        messages.add(message);
        System.out.println("Received from client: " + message);
    }

    @Override
    public String receiveMessage() throws RemoteException {
        return messages.isEmpty() ? "No new messages" : messages.poll();
    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            ChatServer server = new ChatServer();
            java.rmi.Naming.rebind("ChatService", server);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
