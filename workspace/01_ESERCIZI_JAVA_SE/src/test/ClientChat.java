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
import java.util.Scanner;

public class ClientChat {

	public static final int SERVER_SOCKET_PORT = 8053;
	public static final int SERVER_SOCKET_PORT_FOR_REQUEST = 8055;
	public static final String SERVER_HOST = "mercurio";

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		multiThreadClient();
	}
	
	// CLIENT PER SCRIVERE MESSAGGI ALLA CHAT (SUL SERVER E POI AD ALTRI UTENTI)
	private static void multiThreadClient() throws UnknownHostException, IOException, InterruptedException {
			new MessageThread().start();
			
//			while(true) {
//				Thread.sleep(2000);
//				MessagesRequest msgReq = new MessagesRequest();
//				
//				new RequestThread(msgReq).start();
//			}
	}

	private static void sendMessage() throws UnknownHostException, IOException {
		Socket client = new Socket("mercurio", SERVER_SOCKET_PORT);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		out.write("CIAOCIAOCIAO");
		out.close();
		System.out.println("messaggio inviato");
	}

	private static void sendObject() throws IOException {
		while (true) {

			Message m = new Message();
			Scanner s = new Scanner(System.in);
			System.out.println("Inserisci username: ");
			m.setUsername(s.nextLine());
			System.out.println("Inserisci messaggio: ");
			m.setTextMessage(s.nextLine());

			Socket client = new Socket("mercurio", SERVER_SOCKET_PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(m);
			oos.flush();
			oos.reset();
			oos.close();
			os.close();
			client.close();

			if (m.getUsername().equals("quit"))
				break;
		}
		// oos.close();
		// os.close();
		System.out.println("Client chiuso");
	}

	private static void simpleChat() throws IOException, ClassNotFoundException {
		while (true) {

			Message m = new Message();
			Scanner s = new Scanner(System.in);
			System.out.println("Inserisci username: ");
			m.setUsername(s.nextLine());
			System.out.println("Inserisci messaggio: ");
			m.setTextMessage(s.nextLine());

			Socket client = new Socket("localhost", SERVER_SOCKET_PORT);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(m);

			InputStream in = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);

			Message msg = (Message) ois.readObject();
			System.out.println(msg.getUsername() + " " + msg.getTextMessage());

			ois.close();
			in.close();

			oos.close();
			os.close();
			client.close();

			if (m.getTextMessage().equals("quit"))
				break;
		}
		System.out.println("Client chiuso");
	}

//	private static void simpleChatAdvanced() throws IOException, ClassNotFoundException {
//
//		// alla prima connessione scarico tutti i messaggi pregressi
//		LocalDateTime data = LocalDateTime.MIN;
//		Scanner s = new Scanner(System.in);
//		System.out.print("Inserisci username: ");
//		String name = s.nextLine();
//		while (true) {
//
//			Message m = new Message();
//			m.setTimeStamp(data);
//			m.setUsername(name);
//			System.out.print("Inserisci messaggio: ");
//			m.setTextMessage(s.nextLine());
//
//			Socket client = new Socket("localhost", SERVER_SOCKET_PORT);
//			OutputStream os = client.getOutputStream();
//			ObjectOutputStream oos = new ObjectOutputStream(os);
//			oos.writeObject(m);
//			oos.flush();
//			oos.reset();
//
//			InputStream in = client.getInputStream();
//			ObjectInputStream ois = new ObjectInputStream(in);
//
//			ArrayList<Message> messages;
//			try {
//				messages = (ArrayList<Message>) ois.readObject();
//			} catch (Exception ex) {
//				messages = new ArrayList<>();
//			}
//			
//			System.out.println(messages);
//
////			if(messages.isEmpty()) {
//				System.out.println("------------------------------------------------------------------------");
//				int j = 0;
//				String dataString;
//				for (int i = 0; i < messages.size() - 1; i++) {
//					dataString = messages.get(i).getTimeStamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//					System.out.format("%3d|\t%-10s - %-10s - %s\n", j++, dataString, messages.get(i).getUsername(),
//							messages.get(i).getTextMessage());
//				}
//				data = messages.get(messages.size() - 1).getTimeStamp();
//				System.out.println("------------------------------------------------------------------------");	
////			}
//
//
//			ois.close();
//			in.close();
//			oos.close();
//			os.close();
//			client.close();
//
//			if (m.getUsername().equals("quit"))
//				break;
//		}
//		System.out.println("Client chiuso");
//	}
}
