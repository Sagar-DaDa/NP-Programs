package SecureSocket;

import javax.net.ssl.*;

public class SecureSocketClientWithEventHandlers {
    public static void main(String[] args) {
        try {
            // Create an SSL socket factory
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            
            // Create an SSL socket
            SSLSocket socket = (SSLSocket) factory.createSocket("www.verisign.com", 443);
            
            // Add a handshake completed listener
            socket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent event) {
                    System.out.println("Handshake completed!");
                    System.out.println("Cipher Suite: " + event.getCipherSuite());
                    try {
                        // Get the SSL session and certificates
                        SSLSession session = event.getSession();
                        for (java.security.cert.X509Certificate cert : (java.security.cert.X509Certificate[]) session.getPeerCertificates()) {
                            System.out.println("Peer Certificate: " + cert);
                        }
                    } catch (SSLPeerUnverifiedException e) {
                        System.out.println("Peer certificate chain could not be verified.");
                    }
                }
            });
            
            // Start the SSL handshake
            socket.startHandshake();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
