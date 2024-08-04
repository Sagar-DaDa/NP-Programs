package SocketForServers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerServerUsingServerSocket {
    private ServerSocket serverSocket;
    private Socket socket;

    public LoggerServerUsingServerSocket(int port) {
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptMessage() {
        try {
            LogManager logManager = LogManager.getLogManager();
            Logger logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
            InputStream inStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            String message;

            while ((message = reader.readLine()) != null) {
                System.out.println(message);
                logger.log(Level.INFO, message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoggerServerUsingServerSocket server = new LoggerServerUsingServerSocket(2021);
        server.acceptMessage();
    }
}
