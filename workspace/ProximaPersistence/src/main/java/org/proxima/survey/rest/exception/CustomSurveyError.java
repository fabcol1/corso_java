package org.proxima.survey.rest.exception;

import org.proxima.survey.entities.Survey;

public class CustomSurveyError extends Survey {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
    public CustomSurveyError(final String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
