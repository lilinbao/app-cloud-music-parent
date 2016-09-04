/**
 * 
 */
package com.linbao.dao;

import com.linbao.base.IBaseDao;
import com.linbao.model.User;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月3日
 * @version 2.0
 * @param <T>
 * @ToDo 
 */
public interface IUserDao extends IBaseDao<User>{

	public abstract boolean isExist(String username) throws Exception;
	
	public abstract User countUser(String username,String password) throws Exception;
	
}
