package org.proxima.survey.frontutils;

import java.io.Serializable;

public class QuestionCorrection implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String questionID;
	private String[] answers;
	
	
	
	public QuestionCorrection() {
		super();
	}

	public QuestionCorrection(String questionID, String[] answers) {
		super();
		this.questionID = questionID;
		this.answers = answers;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < answers.length; i++) {
			str.append(answers[i].replace("Ans", ""));
			if(i != answers.length-1)
				str.append(", ");
		}
		str.append("\n");
		return str.toString();
	}

	public String getQuestionID() {
		return questionID;
	}

	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	
}
