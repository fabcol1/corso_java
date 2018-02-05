package test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MessageThread extends Thread {
	
	public static final int SERVER_SOCKET_PORT = 8053;
	public static final int SERVER_SOCKET_PORT_FOR_REQUEST = 8055;
	public static final String SERVER_HOST = "mercurio";
	
	String name, message;
	
	public MessageThread(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public void run() {
			Message m = new Message();
			m.setUsername(name);
			m.setTextMessage(message);
			
			Socket client;
			try {
				client = new Socket(SERVER_HOST, SERVER_SOCKET_PORT);
				OutputStream os = client.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(m);
				oos.close();
				os.close();
				client.close();			
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
