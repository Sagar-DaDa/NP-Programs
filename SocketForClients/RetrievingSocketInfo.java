package SocketForClients;

import java.net.*;
import java.io.*;

public class RetrievingSocketInfo {
    public static void main(String[] args) {
        String hostName = "www.google.com";
        int port = 80;
        try {
            Socket theSocket = new Socket(hostName, port);
            System.out.println("Connected to " + theSocket.getInetAddress() +
                " on port " + theSocket.getPort() +
                " from port " + theSocket.getLocalPort() +
                " of " + theSocket.getLocalAddress());
        } catch (UnknownHostException e) {
            System.err.println("I can't find " + hostName);
        } catch (SocketException e) {
            System.err.println("Could not connect to " + hostName);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

