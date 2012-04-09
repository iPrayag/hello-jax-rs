/**
 * 
 */
package org.jcheng.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jcheng
 *
 */
@XmlRootElement
public class BasicStatus {
	
	private boolean success;
	
	private String message;
	
	public BasicStatus() {
		success = true;
		message = "success";
	}
	
	public BasicStatus(String message, boolean success) {
		this.message = message;
		this.success = success;
	}
	
	public BasicStatus(String errorMessage) {
		success = false;
		message = errorMessage;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public BasicStatus setSuccess(boolean success) {
		this.success = success;
		return this;
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
	public BasicStatus setMessage(String message) {
		this.message = message;
		return this;
	}
	

}
