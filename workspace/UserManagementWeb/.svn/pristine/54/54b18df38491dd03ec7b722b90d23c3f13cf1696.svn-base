package org.proxima.survey.frontutils;

import java.io.Serializable;

public class QuestionInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String questionID;
	private String question;
	private String[] answers;
	
	
	public QuestionInfo() {
		super();
	}


	public QuestionInfo(String questionID, String question, String[] answers) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.answers = answers;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("Question: \n" + question + "\nAnswers:\n");
		String[] literals = {"A", "B", "C", "D", "E", "F"};
		for (int i = 0; i < answers.length; i++) {
			str.append(literals[i] + " " + answers[i] + "\n");
		}
		return str.toString();
	}


	public String getQuestionID() {
		return questionID;
	}


	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String[] getAnswers() {
		return answers;
	}


	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	
	
	
}
