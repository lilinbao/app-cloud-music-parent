
package com.linbao.base;

import java.sql.SQLException;
import java.util.List;


import com.linbao.utils.Pager;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年11月29日
 * @param <T>
 * @ToDo 
 */
public interface IBaseDao<T> {

	public abstract List<T> query(T t,Pager pager) throws IndexOutOfBoundsException,NumberFormatException;
	
	public abstract T getById(int id) throws Exception;
	
	public abstract List<T> getByProperty(String property ,Object value, boolean isFuzzy)throws Exception;
	
	public abstract List<T> getAll() throws Exception;
	
	public abstract int add(T t)throws SQLException,NumberFormatException,NullPointerException;
	
	public abstract int update(T t) throws SQLException,NullPointerException;
	
	public abstract int delete(int id)throws SQLException,NumberFormatException;
	
	public abstract int countAll(T t) throws Exception;
	
}
