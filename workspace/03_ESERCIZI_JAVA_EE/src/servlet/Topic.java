package servlet;

public class Topic {
	String question;
	String[] availableReplies;
	String[] correctReplies;
	
	
	public Topic(String question, String[] availableReplies, String[] correctReplies) {
		this.question = question;
		this.availableReplies = availableReplies;
		this.correctReplies = correctReplies;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getAvailableReplies() {
		return availableReplies;
	}
	public void setAvailableReplies(String[] availableReplies) {
		this.availableReplies = availableReplies;
	}
	public String[] getCorrectReplies() {
		return correctReplies;
	}
	public void setCorrectReplies(String[] correctReplies) {
		this.correctReplies = correctReplies;
	}
	
	
}
