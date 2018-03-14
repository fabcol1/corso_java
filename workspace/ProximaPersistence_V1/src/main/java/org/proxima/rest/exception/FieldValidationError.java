/**
 * 
 */
package org.proxima.rest.exception;

import java.awt.TrayIcon.MessageType;

/**
 * @author maurizio
 *
 */
public class FieldValidationError {
    private String filed;
    private String message;
    private MessageType type;
	/**
	 * @return the filed
	 */
	public String getFiled() {
		return filed;
	}
	/**
	 * @param filed the filed to set
	 */
	public void setFiled(String filed) {
		this.filed = filed;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the type
	 */
	public MessageType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(MessageType type) {
		this.type = type;
	}
    
}
