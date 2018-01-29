package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestThread extends Thread {
	MessagesRequest m;
	
	public RequestThread(MessagesRequest m) {
		this.m = m;
	}
	
	public void run() {
		Socket client;
		try {
			client = new Socket("mercurio", ClientChat.SERVER_SOCKET_PORT_FOR_REQUEST);
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
			
			for(Message m : messages) {
				System.out.println(m.getUsername() + " " + m.getTextMessage());
			}
			ois.close();
			in.close();
			oos.close();
			os.close();
			client.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
