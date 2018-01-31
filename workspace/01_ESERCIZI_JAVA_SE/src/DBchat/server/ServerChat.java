package DBchat.server;

import java.io.IOException;

public class ServerChat {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		multiThreadServer();
	}
	
	public static final int SERVER_SOCKET_PORT = 8053;
	public static final int SERVER_SOCKET_PORT_FOR_REQUEST = 8055;
	
	private static void multiThreadServer() {
		CommunityMessageServer messageServer = new CommunityMessageServer();
		messageServer.start();
		CommunityRequestServer requestServer = new CommunityRequestServer();
		requestServer.start();
	}
}
