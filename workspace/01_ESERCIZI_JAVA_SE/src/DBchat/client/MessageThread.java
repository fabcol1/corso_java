package DBchat.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import DBchat.Message;

public class MessageThread extends Thread {
	
	public void run() {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			Message m = new Message();
			System.out.println("Inserisci username: ");
			m.setUsername(s.nextLine());
			System.out.println("Inserisci messaggio: ");
			m.setTextMessage(s.nextLine());
			
			Socket client;
			try {
				client = new Socket(ClientChat.SERVER_HOST, ClientChat.SERVER_SOCKET_PORT);
				OutputStream os = client.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(m);
				oos.close();
				os.close();
				client.close();			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (m.getUsername().equals("quit"))
				break;
		}
		System.out.println("Client chiuso");
	}
}
