/**
 * 
 */
package com.linbao.exception;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年6月12日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class GenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;
	private String forwardTo;
	
	public GenericException() {
		super();
	}
	/**
	 * @param errorMessage
	 */
	public GenericException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * @param errorMessage
	 * @param errorCode
	 */
	public GenericException(String errorMessage, String errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	/**
	 * @param errorMessage
	 * @param errorCode
	 * @param forwardTo
	 */
	public GenericException(String errorMessage, String errorCode,String forwardTo) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.forwardTo = forwardTo;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the forwardTo
	 */
	public String getForwardTo() {
		return forwardTo;
	}
	/**
	 * @param forwardTo the forwardTo to set
	 */
	public void setForwardTo(String forwardTo) {
		this.forwardTo = forwardTo;
	}

}
