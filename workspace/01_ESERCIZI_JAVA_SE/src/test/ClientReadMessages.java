package test;

public class ClientReadMessages {
	// CLIENT PER LEGGERE I MESSAGGI SULLA CHAT
	public static void main(String[] args) throws InterruptedException {
		MessagesRequest msgReq = new MessagesRequest();
			
		int i = 0;
		while(i < 2) {
			
			Thread.sleep(2000);
			new RequestThread(msgReq).start();
			i++;
		}
	}
}
