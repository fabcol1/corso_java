package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleChatSerialization implements Runnable {

	Socket client;

	public SimpleChatSerialization(Socket client) {
		this.client = client;
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

			// leggo Message da Client
			is = client.getInputStream();
			ois = new ObjectInputStream(is);
			m = (Message) ois.readObject();
			System.out.println(m.getUsername() + " " + m.getTextMessage());

			// serializzo il messaggio in locale
			// per data temporale LOCALDATETIME -> ISTANZIARLO AL MOMENTO CORRENTE GG/MM/YY HH/MM/SS 
			// OTTENGO STRINGA SIGNIFICATIVA E QUESTA STRINGA � IL NOME DEL FILE 
			LocalDateTime data = LocalDateTime.now();
			String dataString = data.format(DateTimeFormatter.ofPattern("yyyMMdd_HHmmss_SSSS")); 
			
			serializeWriteMessage(m, dataString);

			// deserializzo e invio
			os = client.getOutputStream();
			oos = new ObjectOutputStream(os);
			oos.writeObject(deserializeReadMessage(dataString));

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
	
	private void serializeWriteMessage(Message mex, String name) throws IOException {
		FileOutputStream fos = null;
		fos = new FileOutputStream("C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\messaggiSerializzati\\" + name);
		ObjectOutputStream oos;
		oos = new ObjectOutputStream(fos);
		oos.writeObject(mex);
		oos.close();
		fos.close();
	}
	
	
	// PATH "C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\messaggioSerializzato.ser"
	private Message deserializeReadMessage(String name) throws IOException, ClassNotFoundException {
		Message mex = null;
		FileInputStream fis = null;
		fis = new FileInputStream("C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\messaggiSerializzati\\" + name);
		ObjectInputStream ois;
		ois = new ObjectInputStream(fis);
		mex = (Message) ois.readObject();
		ois.close();
		fis.close();
		
		return mex;
	}

}