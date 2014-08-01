/**
 * @author hiteshgarg
 * A custom Exception class.
 */
package com.nagarro.assignment5.exception;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4076611916863296393L;
	private String message = null;

	public CustomException(){
		super();
	}
	public CustomException(String message) {
		super();
		this.message = message;
	}
	
	public String getErrorMessage(){
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
