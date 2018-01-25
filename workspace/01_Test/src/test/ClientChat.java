package test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientChat {
	
	public static final int SERVER_SOCKET_PORT = 8050;

	public static void main(String[] args) throws IOException {
		sendObject();
	}
	
	
	private static void sendMessage() throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", SERVER_SOCKET_PORT);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		out.write("CIAOCIAOCIAO");
		out.close();
		System.out.println("messaggio inviato");
	}
	
	private static void sendObject() throws IOException {

		
		while(true) {
			Socket client = new Socket("localhost",  SERVER_SOCKET_PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			Message m = new Message();
			Scanner s = new Scanner(System.in);
			System.out.println("Inserisci username: ");
			m.setUsername(s.nextLine());
			System.out.println("Inserisci messaggio: ");
			m.setTextMessage(s.nextLine());
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

}
