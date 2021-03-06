package esempi;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class esempioNIO {
	public static void main(String[] args) {
		try {
			readLocalFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readLocalFile() throws IOException {
		String filePathToRead = "C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\workspace\\dacopiare.txt";
		File fileToRead = new File(filePathToRead);
		FileInputStream fis = new FileInputStream(fileToRead);

		FileChannel inChannel = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		while (inChannel.read(buffer) > 0) {
			buffer.flip();
			for (int i = 0; i < buffer.limit(); i++) {
				System.out.print((char) buffer.get());
			}
			buffer.clear();
		}
		inChannel.close();
		fis.close();
	}
	
	private static void writeToLocalFile() throws IOException {
		String filePathToWrite = "C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\workspace\\scritto.txt";
		FileOutputStream fos = new FileOutputStream(filePathToWrite);
		FileChannel outChannel = fos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		String textToWrite = "ciao";
		buffer.put(textToWrite.getBytes());
		buffer.flip();
		outChannel.write(buffer);
//		buffer.clear();
		outChannel.close();
		fos.close();
	}
}
