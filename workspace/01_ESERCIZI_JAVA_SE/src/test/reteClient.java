package test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class reteClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket requestSocket = new Socket("mercurio", reteServer.SERVER_SOCKET_PORT);
		System.out.println("CONNECTION.... OK...");
	}

}
