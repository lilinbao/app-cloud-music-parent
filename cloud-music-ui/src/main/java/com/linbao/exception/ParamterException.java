/**
 * 
 */
package com.linbao.exception;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月18日
 * @version 2.0
 * @param <T>
 * @ToDo 
 */
public class ParamterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg = "";

	/**
	 *@category constructor for this class
	 *@param msg String
	 */
	public ParamterException(String msg) {
		System.out.println("one or more paramters that required are missing , please check and recall" + msg);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
