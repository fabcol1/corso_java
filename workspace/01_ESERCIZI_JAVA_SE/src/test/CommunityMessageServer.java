package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommunityMessageServer extends Thread {
	
	public void run() {
		ServerSocket serverSock;
		try {
			serverSock = new ServerSocket(ServerChat.SERVER_SOCKET_PORT);
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("##### SERVER HOSTNAME/IP: " + address + " #####");

			 while (true) {
					System.out.println("################################################");
					System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY #####");
					System.out.println("Server socket started. Listening on port: " + ServerChat.SERVER_SOCKET_PORT);
					
					Socket client = serverSock.accept();
					
					InetAddress currentClientInetAddress = client.getInetAddress();
					System.out.println("Connection established with: " + currentClientInetAddress);

					InputStream is;
					ObjectInputStream ois;
					Message m = null;
					try {
						// leggo Message da Client
						is = client.getInputStream();
						ois = new ObjectInputStream(is);
						try {
							m = (Message) ois.readObject();
						} catch(Exception e) {
							m = new Message();
							m.setUsername("Errore");
							m.setTextMessage("Errore di cast");
						}
					
						// memorizzo l'ultima richiesta fatta dal client per i messaggi
						LocalDateTime data = LocalDateTime.now();
						String dataString = data.format(DateTimeFormatter.ofPattern("yyyMMdd_HHmmss_SSSS"));
						System.out.println(m.getUsername() + " " + m.getTextMessage() + " " + dataString);
						serializeWriteMessage(m, dataString);

						System.out.println("Closing connection with client");
						ois.close();
						is.close();
						client.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void serializeWriteMessage(Message mex, String name) throws IOException {
		FileOutputStream fos = null;
		fos = new FileOutputStream("C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\messaggiSerializzati\\" + name);
		ObjectOutputStream oos;
		oos = new ObjectOutputStream(fos);
		oos.writeObject(mex);
		oos.close();
		fos.close();
	}

}
