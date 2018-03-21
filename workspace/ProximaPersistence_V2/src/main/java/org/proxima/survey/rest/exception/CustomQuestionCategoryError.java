package org.proxima.survey.rest.exception;

import org.proxima.survey.entities.QuestionCategory;

public class CustomQuestionCategoryError extends QuestionCategory {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public CustomQuestionCategoryError(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
