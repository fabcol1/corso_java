package test;

import java.io.Serializable;
//import java.time.LocalDateTime;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	
//	private LocalDateTime timeStamp;
	private String username;
	private String textMessage;
	private String lastTimeActive;
	
	public String getLastTimeActive() {
		return lastTimeActive;
	}
	public void setLastTimeActive(String lastTimeActive) {
		this.lastTimeActive = lastTimeActive;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTextMessage() {
		return textMessage;
	}
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
//	public LocalDateTime getTimeStamp() {
//		return timeStamp;
//	}
//	public void setTimeStamp(LocalDateTime timeStamp) {
//		this.timeStamp = timeStamp;
//	}
}
