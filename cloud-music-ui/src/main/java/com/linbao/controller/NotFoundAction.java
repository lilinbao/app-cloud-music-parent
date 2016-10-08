/**
 * 
 */
package com.linbao.controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年6月12日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class NotFoundAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 0622L;
	private static final String classname = NotFoundAction.class.getSimpleName();
	private String appContext;
	public NotFoundAction(){
		System.out.println(classname + " init completed");
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("Action Not Found");
		return SUCCESS;
	}
	/**
	 * @return the appContext
	 */
	public String getAppContext() {
		return appContext;
	}
	/**
	 * @param appContext the appContext to set
	 */
	public void setAppContext(String appContext) {
		this.appContext = appContext;
	}
	

}
