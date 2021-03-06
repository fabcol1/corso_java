package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerChat {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		multiThreadServer();
	}
	
	public static final int SERVER_SOCKET_PORT = 8053;
	public static final int SERVER_SOCKET_PORT_FOR_REQUEST = 8055;
	
	private static void multiThreadServer() {
		CommunityMessageServer messageServer = new CommunityMessageServer();
		messageServer.start();
		CommunityRequestServer requestServer = new CommunityRequestServer();
		requestServer.start();
	}
	
	private static void multiUserSimpleChatSerialization() throws IOException, ClassNotFoundException {
		ServerSocket serverSock = new ServerSocket(ClientChat.SERVER_SOCKET_PORT);
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("##### SERVER HOSTNAME/IP: " + address + " #####");
		ExecutorService executor = Executors.newCachedThreadPool();

		 while (true) {
				System.out.println("################################################");
				System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY #####");
				System.out.println("Server socket started. Listening on port: " + ClientChat.SERVER_SOCKET_PORT);
				
				Socket client = serverSock.accept();
//				executor.submit(new SimpleChatSerialization(client));
				executor.submit(new SimpleChatAdvSerialization(client));
		 }
	}
	
	private static void objectServerMultiUserSimpleChat() throws IOException, ClassNotFoundException {
		ServerSocket serverSock = new ServerSocket(ClientChat.SERVER_SOCKET_PORT);
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("##### SERVER HOSTNAME/IP: " + address + " #####");
		ExecutorService executor = Executors.newCachedThreadPool();

		ArrayList<Message> messages = new ArrayList<>();
		
		 while (true) {
				System.out.println("################################################");
				System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY #####");
				System.out.println("Server socket started. Listening on port: " + ClientChat.SERVER_SOCKET_PORT);
				
				Socket client = serverSock.accept();
				executor.submit(new MyClientHandlerSimpleChat(client, messages));
		 }
	}
	
	private static void objectServerMultiUser() throws IOException, ClassNotFoundException {
		ServerSocket serverSock = new ServerSocket(ClientChat.SERVER_SOCKET_PORT);
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("##### SERVER HOSTNAME/IP: " + address + " #####");
		ExecutorService executor = Executors.newCachedThreadPool();

		 while (true) {
				System.out.println("################################################");
				System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY #####");
				System.out.println("Server socket started. Listening on port: " + ClientChat.SERVER_SOCKET_PORT);
				
				Socket client = serverSock.accept();
				executor.submit(new MyClientHandler(client));
		 }
	}
	
	private static void objectServer() throws IOException, ClassNotFoundException {
		ServerSocket serverSock = new ServerSocket(ClientChat.SERVER_SOCKET_PORT);
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("##### SERVER HOSTNAME/IP: " + address + " #####");

		 while (true) {
				System.out.println("################################################");
				System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY #####");
				System.out.println("Server socket started. Listening on port: " + ClientChat.SERVER_SOCKET_PORT);
				
				Socket client = serverSock.accept();
				InetAddress currentClientInetAddress = client.getInetAddress();
				System.out.println("Connection established with: " + currentClientInetAddress);
			
				InputStream is = client.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				
				Message m = (Message) ois.readObject();
				System.out.println(m.getUsername() + " " + m.getTextMessage());
	            System.out.println("Closing connection with client");
	            ois.close();
	            is.close();
	            client.close();
	            
	            if(m.getUsername().equals("quit")) break;
		 }
		 
		 serverSock.close();
		 System.out.println("Server chiuso");
	}
	
	private static void messageServer() throws IOException {
		ServerSocket serverSock = new ServerSocket(ClientChat.SERVER_SOCKET_PORT);
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("##### SERVER HOSTNAME/IP: " + address + " #####");
		
		 while (true) {
				System.out.println("################################################");
				System.out.println("##### SERVER HOSTNAME/IP: " + address + " READY #####");
				System.out.println("Server socket started. Listening on port: " + ClientChat.SERVER_SOCKET_PORT);
				
				Socket client = serverSock.accept();
				InetAddress currentClientInetAddress = client.getInetAddress();
				System.out.println("Connection established with: " + currentClientInetAddress);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				String s = in.readLine();
				System.out.println(s);
				
	            while ((s = in.readLine()) != null) {
	                System.out.println(s);
	            	if(s.equals("quit")) break;
	            }

	            System.out.println("Closing connection with client");
	            in.close();
	            client.close();
	 }
	}
}
