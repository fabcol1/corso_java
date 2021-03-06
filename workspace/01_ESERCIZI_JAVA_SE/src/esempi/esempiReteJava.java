package esempi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class esempiReteJava {

	public static void main(String[] args) throws IOException {
		executeConnectionWithStreamReading();
	}
	
	private static void printInetAddress() throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		
		address = InetAddress.getByName("starwave.com");
		System.out.println(address);
		
		InetAddress[] sw = InetAddress.getAllByName("UTENTE8");
		
		for(int i = 0; i < sw.length; i++) {
			System.out.println(sw[i]);
		}
	}

	private static void executeConnection() throws IOException {
		URL page = new URL("http://www.google.com");
		URLConnection xxxConn = page.openConnection();
		xxxConn.connect();
		System.out.println("Connessione riuscita...");
	}
	
	private static void executeConnectionWithStreamReading() throws IOException {
		URL page = new URL("https://www.google.com");
		URLConnection xxxConn = page.openConnection();
		System.out.println(xxxConn.getClass());
		BufferedReader in = new BufferedReader(
				new InputStreamReader(xxxConn.getInputStream())
				);
		String inputLine;
		
		while((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		
		in.close();
		System.out.println("close");
	}
}
