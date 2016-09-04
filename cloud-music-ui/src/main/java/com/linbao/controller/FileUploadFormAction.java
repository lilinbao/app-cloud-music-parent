/**
 * 
 */
package com.linbao.controller;

import com.linbao.exception.AuthorizationException;
import com.opensymphony.xwork2.Action;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年6月17日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class FileUploadFormAction extends BaseAction{

	private static final String classname = FileUploadFormAction.class.getName();
/**
	 * 
	 */
	public FileUploadFormAction() {
		System.out.println( classname + " init completed" );
	}
	private static final long serialVersionUID = 1L;
	
	public String form() throws AuthorizationException{
		return Action.SUCCESS;
	}
}
