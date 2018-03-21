/**
 * 
 */
package org.proxima.rest.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maurizio
 *
 */
public class FieldValidationErrorDetails {

	private String error_title;
    private int error_status;
    private String error_detail;
    private long error_timeStamp;
    private String error_path;
    private String error_developer_Message;
    private Map<String, List<FieldValidationError>> errors =
                    new HashMap<String, List<FieldValidationError>>();
	/**
	 * @return the error_title
	 */
	public String getError_title() {
		return error_title;
	}
	/**
	 * @param error_title the error_title to set
	 */
	public void setError_title(String error_title) {
		this.error_title = error_title;
	}
	/**
	 * @return the error_status
	 */
	public int getError_status() {
		return error_status;
	}
	/**
	 * @param error_status the error_status to set
	 */
	public void setError_status(int error_status) {
		this.error_status = error_status;
	}
	/**
	 * @return the error_detail
	 */
	public String getError_detail() {
		return error_detail;
	}
	/**
	 * @param error_detail the error_detail to set
	 */
	public void setError_detail(String error_detail) {
		this.error_detail = error_detail;
	}
	/**
	 * @return the error_timeStamp
	 */
	public long getError_timeStamp() {
		return error_timeStamp;
	}
	/**
	 * @param error_timeStamp the error_timeStamp to set
	 */
	public void setError_timeStamp(long error_timeStamp) {
		this.error_timeStamp = error_timeStamp;
	}
	/**
	 * @return the error_path
	 */
	public String getError_path() {
		return error_path;
	}
	/**
	 * @param error_path the error_path to set
	 */
	public void setError_path(String error_path) {
		this.error_path = error_path;
	}
	/**
	 * @return the error_developer_Message
	 */
	public String getError_developer_Message() {
		return error_developer_Message;
	}
	/**
	 * @param error_developer_Message the error_developer_Message to set
	 */
	public void setError_developer_Message(String error_developer_Message) {
		this.error_developer_Message = error_developer_Message;
	}
	/**
	 * @return the errors
	 */
	public Map<String, List<FieldValidationError>> getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(Map<String, List<FieldValidationError>> errors) {
		this.errors = errors;
	}
    
	
}
