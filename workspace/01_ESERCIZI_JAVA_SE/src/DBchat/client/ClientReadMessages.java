package DBchat.client;

import DBchat.MessagesRequest;

public class ClientReadMessages {
	// CLIENT PER LEGGERE I MESSAGGI SULLA CHAT
	public static void main(String[] args) throws InterruptedException {
	
		MessagesRequest msgReq = new MessagesRequest();
				
		while(true) {
			Thread.sleep(2000);
			new RequestThread(msgReq).start();
		}
	}
}
