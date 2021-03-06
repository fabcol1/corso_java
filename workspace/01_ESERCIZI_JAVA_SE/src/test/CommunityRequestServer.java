package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommunityRequestServer extends Thread {
	
	public void run() {
		ServerSocket serverSock;
		try {
			serverSock = new ServerSocket(ServerChat.SERVER_SOCKET_PORT_FOR_REQUEST);
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("##### SERVER HOSTNAME/IP: " + address + " #####");

			 while (true) {
					System.out.println("################################################");
					System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY #####");
					System.out.println("Server socket started. Listening on port: " + ServerChat.SERVER_SOCKET_PORT_FOR_REQUEST);
					
					Socket client = serverSock.accept();
					
					InetAddress currentClientInetAddress = client.getInetAddress();
					System.out.println("Connection established with: " + currentClientInetAddress);

					InputStream is;
					ObjectInputStream ois;
					OutputStream os;
					ObjectOutputStream oos;
					
					MessagesRequest req = null;
					Message[] m = new Message[1];
					try {
						// leggo Message da Client
						is = client.getInputStream();
						ois = new ObjectInputStream(is);
						try {
							req = (MessagesRequest) ois.readObject();
						} catch(Exception e) {
							System.out.println("Errore di cast");
						}
					
						Message msg = new Message();
						msg.setUsername("Risposta");
						msg.setTextMessage("Messaggio di risposta");
						m[0] = msg;
						
						os = client.getOutputStream();
						oos = new ObjectOutputStream(os);
						oos.writeObject(m);
						
						System.out.println("Closing connection with client");
						oos.close();
						os.close();
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

}