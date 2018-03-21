package org.proxima.survey.rest.exception;

import org.proxima.survey.entities.Question;

public class CustomQuestionError extends Question {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public CustomQuestionError(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
