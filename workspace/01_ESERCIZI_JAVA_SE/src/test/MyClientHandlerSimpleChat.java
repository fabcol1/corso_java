package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class MyClientHandlerSimpleChat implements Runnable {

	Socket client;
	List<Message> messages;

	public MyClientHandlerSimpleChat(Socket client, List<Message> messages) {
		this.client = client;
		this.messages = messages;
	}

	@Override
	public void run() {
		InetAddress currentClientInetAddress = client.getInetAddress();
		System.out.println("Connection established with: " + currentClientInetAddress);

		InputStream is;
		ObjectInputStream ois;
		OutputStream os;
		ObjectOutputStream oos;
		Message m = null;
		try {
			os = client.getOutputStream();
			oos = new ObjectOutputStream(os);
			oos.writeObject(messages);
//			oos.flush();
//			oos.reset();

			
			is = client.getInputStream();
			ois = new ObjectInputStream(is);
			m = (Message) ois.readObject();
			messages.add(m);
			System.out.println(m.getUsername() + " " + m.getTextMessage());
			System.out.println("Closing connection with client");
			oos.close();
			os.close();
			ois.close();
			is.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}