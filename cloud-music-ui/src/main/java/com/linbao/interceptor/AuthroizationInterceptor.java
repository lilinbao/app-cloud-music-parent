/**
 * 
 */
package com.linbao.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.linbao.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年6月9日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class AuthroizationInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("the action name is "+ServletActionContext.getContext().getName());
		
		Map<String,Object> context = ServletActionContext.getContext().getSession();
		
		User u = (User) context.get("currentUser");
		if(null == u){
			System.out.println("authroization fail , invaild User");
			
			return "decline";
		}
		return ai.invoke();
	}

}
