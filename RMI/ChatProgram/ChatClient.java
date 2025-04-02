import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Chat chat = (Chat) Naming.lookup("rmi://localhost/ChatService");

            Scanner scanner = new Scanner(System.in);
            String message;

            System.out.println("Enter your message: ");
            while (true) {
                message = scanner.nextLine();
                chat.sendMessage("Client: " + message);

                String response = chat.receiveMessage();
                System.out.println("Server response: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
