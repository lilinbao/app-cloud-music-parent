/**
 * 
 */
package com.linbao.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.NonUniqueObjectException;

import com.linbao.exception.InvalidInputException;
import com.linbao.model.Resources;
import com.linbao.model.User;
import com.linbao.utils.Pager;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月5日
 * @version 2.0
 * @param <T>
 * @ToDo 
 */
public interface IUserService {

	public abstract User isExistUser(String username , String password) throws Exception;
	
	public abstract int add(User user) throws SQLException,NumberFormatException,NullPointerException;
	
	public abstract User getById(int id) ;
	
	public abstract int delete(User user) throws SQLException,NumberFormatException,NonUniqueObjectException;
	
	public abstract int update(User user) throws SQLException,NullPointerException, InvalidInputException;
	
	public abstract List<User> getByRole(int groupId) throws NullPointerException,NumberFormatException;
	
	public abstract List<User> getByPage(Pager pager) throws IndexOutOfBoundsException,NumberFormatException;
	
	public abstract List<User> getByName(String name) throws Exception;
	
	public abstract List<User> getByUserName(String userName) throws Exception;

	public abstract List<User> getAll() throws Exception;

	public abstract List<User> getByEmail(String email)throws Exception;
	
	public List<Resources> getResourcesByUser(int userId) throws Exception;
}
