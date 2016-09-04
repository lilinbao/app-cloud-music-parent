/**
 * 
 */
package com.linbao.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




import com.linbao.exception.AuthorizationException;
import com.linbao.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年3月17日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class BaseAction extends ActionSupport{

	public static Logger logger = LoggerFactory.getLogger(BaseAction.class);
	public String appContext = "ace";
	public BaseAction(){
		Locale locale = Locale.getDefault();
		//String locate = (String)ServletActionContext.getContext().get("WW_TRANS_I18N_LOCALE");
		logger.info("java.util.locate is  " + locale);
		logger.error("current app ui setting is "+ appContext);
		logger.info("BaseAction init completed");
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Pager pager;
	public String parameters;
	
	public Map<String , Object> session;
	HttpServletRequest request;
	@Override
	public String execute() throws AuthorizationException{
		throw new AuthorizationException();
	}
	/**
	 * @return the pager
	 */
	public Pager getPager() {
		return pager;
	}
	/**
	 * @param pager the pager to set
	 */
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	/**
	 * @return the parameters
	 */
	public String getParameters() {
		return parameters;
	}
	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	/**
	 * @return the map
	 */
	public Map<String, Object> getSession() {
		
		return null == session ? session = ServletActionContext.getContext().getSession(): session;
	}
	/**
	 * @param map the map to set
	 */
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		
		return null == request ? ServletActionContext.getRequest():request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
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
