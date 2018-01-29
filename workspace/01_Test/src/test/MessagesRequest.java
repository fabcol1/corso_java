package test;

import java.io.Serializable;

public class MessagesRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String lastMessageSendTime;
	
	public String getLastMessageSendTime() {
		return lastMessageSendTime;
	}
	public void setLastMessageSendTime(String lastMessageSendTime) {
		this.lastMessageSendTime = lastMessageSendTime;
	}
}
