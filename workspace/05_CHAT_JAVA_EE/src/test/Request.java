package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Request {
	public static final int SERVER_SOCKET_PORT = 8053;
	public static final int SERVER_SOCKET_PORT_FOR_REQUEST = 8055;
	public static final String SERVER_HOST = "mercurio";
	MessagesRequest m;
	
	public Request(MessagesRequest m) {
		this.m = m;
	}
	
	public String run() {
		Socket client;
		try {
			StringBuffer buffer = new StringBuffer();
			client = new Socket(SERVER_HOST, SERVER_SOCKET_PORT_FOR_REQUEST);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(m);
			InputStream in = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);

			Message[] messages = null;
			try {
				messages = (Message[]) ois.readObject();
			} catch (Exception ex) {
				System.out.println("Log: eccezione in lettura da server");
			}
			
			System.out.println(messages.length);
			for(Message msg : messages) {
				System.out.println(msg.getLastTimeActive());
			}
			
			for(Message msg : messages) {
				buffer.append(msg.getLastTimeActive()). append(" ")
								.append(msg.getUsername()).append(" ")
								.append(msg.getTextMessage()).append("\n");
			}
			
			if(messages!=null && messages.length!=0) {
				m.setLastMessageSendTime(messages[messages.length-1].getLastTimeActive());
			}
			
			ois.close();
			in.close();
			oos.close();
			os.close();
			client.close();	
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "ERROR";
		}

	}

}
