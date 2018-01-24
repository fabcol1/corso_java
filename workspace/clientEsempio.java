import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientEsempio {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket requestSocket = new Socket("192.168.178.38", 8051);
		System.out.println("CONNECTION.... OK...");
	}

}