package org.proxima.error;

import org.proxima.entities.Bitcoin;

public class CustomErrorType extends Bitcoin {
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public CustomErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
