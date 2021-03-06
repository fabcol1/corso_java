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
			client = new Socket(ClientChat.SERVER_HOST, ClientChat.SERVER_SOCKET_PORT_FOR_REQUEST);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(m);
			
//			System.out.println(m.getLastMessageSendTime());
			InputStream in = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);

			Message[] messages = null;
			try {
				messages = (Message[]) ois.readObject();
			} catch (Exception ex) {
				System.out.println("Log: eccezione in lettura da server");
			}
			
			for(Message msg : messages) {
				System.out.println(msg.getUsername() + " " + msg.getTextMessage() + " " + msg.getLastTimeActive() );
			}
			
			if(messages!=null && messages.length!=0) {
				m.setLastMessageSendTime(messages[messages.length-1].getLastTimeActive());
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
