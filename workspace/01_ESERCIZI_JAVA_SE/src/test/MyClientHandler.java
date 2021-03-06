package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MyClientHandler implements Runnable {

	Socket client;

	public MyClientHandler(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		InetAddress currentClientInetAddress = client.getInetAddress();
		System.out.println("Connection established with: " + currentClientInetAddress);

		InputStream is;
		ObjectInputStream ois;
		Message m = null;
		try {
			is = client.getInputStream();
			ois = new ObjectInputStream(is);
			m = (Message) ois.readObject();
			System.out.println(m.getUsername() + " " + m.getTextMessage());
			System.out.println("Closing connection with client");
			client.close();
			ois.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
