package DBchat.client;

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

import DBchat.Message;

public class ClientChat {

	public static final int SERVER_SOCKET_PORT = 8053;
	public static final int SERVER_SOCKET_PORT_FOR_REQUEST = 8055;
	public static final String SERVER_HOST = "localhost";

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		multiThreadClient();
	}
	
	// CLIENT PER SCRIVERE MESSAGGI ALLA CHAT (SUL SERVER E POI AD ALTRI UTENTI)
	private static void multiThreadClient() throws UnknownHostException, IOException, InterruptedException {
			new MessageThread().start();
	}
}
