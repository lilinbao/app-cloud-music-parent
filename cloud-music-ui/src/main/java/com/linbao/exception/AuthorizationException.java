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
public class AuthorizationException extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String authType;
	private String reslut;
	
	/**
	 * 
	 */
	public AuthorizationException() {
		super();
	}

	/**
	 * @param authType
	 * @param reslut
	 */
	public AuthorizationException(String authType, String reslut) {
		this.authType = authType;
		this.reslut = reslut;
	}

	/**
	 * @return the authType
	 */
	public String getAuthType() {
		return authType;
	}

	/**
	 * @param authType the authType to set
	 */
	public void setAuthType(String authType) {
		this.authType = authType;
	}

	/**
	 * @return the reslut
	 */
	public String getReslut() {
		return reslut;
	}

	/**
	 * @param reslut the reslut to set
	 */
	public void setReslut(String reslut) {
		this.reslut = reslut;
	}
	
}
