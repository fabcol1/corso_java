package es.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import test.Message;

public class SerializeTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		serializeWriteMessage();
		Message msg = deserializeReadMessage();
		System.out.println(msg.getUsername() + " - " + msg.getTextMessage() );
	}
	
	private static void serializeWriteMessage() throws IOException {
		Message mex = new Message();
		mex.setUsername("usernameeeeeeeeeeee");
		mex.setTextMessage("testooooooooooooooooooooooooooo");
		
		FileOutputStream fos = null;
		fos = new FileOutputStream("C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\messaggioSerializzato.ser");
		ObjectOutputStream oos;
		oos = new ObjectOutputStream(fos);
		oos.writeObject(mex);
		oos.close();
		fos.close();
	}
	
	private static Message deserializeReadMessage() throws IOException, ClassNotFoundException {
		Message mex = null;
		
		FileInputStream fis = null;
		fis = new FileInputStream("C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\messaggioSerializzato.ser");
		ObjectInputStream ois;
		ois = new ObjectInputStream(fis);
		mex = (Message) ois.readObject();
		ois.close();
		fis.close();
		
		return mex;
	}

}
