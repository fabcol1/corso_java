package test;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SimpleChatAdvSerialization implements Runnable {

	Socket client;

	public SimpleChatAdvSerialization(Socket client) {
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
		
			// memorizzo l'ultima richiesta fatta dal client per i messaggi
			LocalDateTime lastRequest = m.getTimeStamp();

			LocalDateTime data = LocalDateTime.now();
			m.setTimeStamp(data);
			String dataString = data.format(DateTimeFormatter.ofPattern("yyyMMdd_HHmmss_SSSS"));
			System.out.println(m.getUsername() + " " + m.getTextMessage() + " " + dataString);

			// serializzo il messaggio in locale
			// per data temporale LOCALDATETIME -> ISTANZIARLO AL MOMENTO CORRENTE GG/MM/YY HH/MM/SS 
			// OTTENGO STRINGA SIGNIFICATIVA E QUESTA STRINGA � IL NOME DEL FILE
			System.out.println(m.getTextMessage().isEmpty());

//			if(!m.getTextMessage().isEmpty()) {
				serializeWriteMessage(m, dataString);
//			}
			// deserializzo e invio
			os = client.getOutputStream();
			oos = new ObjectOutputStream(os);
			List<Message> messages = deserializeMessages(lastRequest);
			oos.writeObject(messages);
			oos.flush();
			oos.reset();

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
	
	
	private List<Message> deserializeMessages(LocalDateTime lastRequest) throws IOException, ClassNotFoundException {
		File dir = new File("C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\messaggiSerializzati\\");
		if(!dir.isDirectory()) return null;
		File[] backupDir = dir.listFiles();
		
		ArrayList<Message> messages = new ArrayList<>();
		Message m;
		for(File file : backupDir) {
			m = deserializeReadMessage(file.getName());
			if(m.getTimeStamp().isAfter(lastRequest)) {
				messages.add(m);	
			}
		}
		return messages;
	}
	
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