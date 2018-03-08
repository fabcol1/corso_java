package org.proxima.error;

import org.proxima.entities.User;

public class CustomErrorType extends User {
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public CustomErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
