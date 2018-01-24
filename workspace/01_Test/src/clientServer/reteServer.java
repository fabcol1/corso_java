package clientServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class reteServer {

	public static void main(String[] args) throws IOException {
		socketConnection();
	}
	

	public final static int SERVER_SOCKET_PORT = 8051;
	
	private static void socketConnection() throws IOException {
		ServerSocket serverSock = new ServerSocket(SERVER_SOCKET_PORT);
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("##### SERVER HOSTNAME/IP: " + address + " #####");
		while(true) {
			System.out.println("\n\n\n");
			System.out.println("################################################");
			System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY #####");
			System.out.println("Server socket started. Listening on port: " + SERVER_SOCKET_PORT);
			Socket client = serverSock.accept();
			InetAddress currentClientInetAddress = client.getInetAddress();
			System.out.println("Connection established with: " + currentClientInetAddress);
		}
	}

}
