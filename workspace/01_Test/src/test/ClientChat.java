package test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientChat {
	
	public static final int SERVER_SOCKET_PORT = 8057;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		simpleChat();
	}
	
	
	private static void sendMessage() throws UnknownHostException, IOException {
		Socket client = new Socket("mercurio", SERVER_SOCKET_PORT);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		out.write("CIAOCIAOCIAO");
		out.close();
		System.out.println("messaggio inviato");
	}
	
	private static void sendObject() throws IOException {
		while(true) {
			
			Message m = new Message();
			Scanner s = new Scanner(System.in);
			System.out.println("Inserisci username: ");
			m.setUsername(s.nextLine());
			System.out.println("Inserisci messaggio: ");
			m.setTextMessage(s.nextLine());
			
			Socket client = new Socket("mercurio",  SERVER_SOCKET_PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(m);
			oos.flush();
			oos.reset();
			oos.close();
			os.close();
			client.close();
			
			if(m.getUsername().equals("quit")) break;
		}
//		oos.close();
//		os.close();
		System.out.println("Client chiuso");		
	}
	
	private static void simpleChat() throws IOException, ClassNotFoundException {
		while(true) {
			
			Message m = new Message();
			Scanner s = new Scanner(System.in);
			System.out.println("Inserisci username: ");
			m.setUsername(s.nextLine());
			System.out.println("Inserisci messaggio: ");
			m.setTextMessage(s.nextLine());
			
			Socket client = new Socket("localhost",  SERVER_SOCKET_PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(m);
			
			InputStream in = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);
			
//			Message msg = (Message) ois.readObject();
//			System.out.println(msg.getUsername() + " " + msg.getTextMessage());

			ArrayList<Message> messages = (ArrayList<Message>) ois.readObject();
			for(Message msg : messages) {
				System.out.println(msg.getUsername() + " " + msg.getTextMessage());
			}

			ois.close();
			in.close();
			
			oos.close();
			os.close();
			client.close();
			
			if(m.getUsername().equals("quit")) break;
		}
//		oos.close();
//		os.close();
		System.out.println("Client chiuso");		
	}
}
