package com.linbao.api.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2015年12月6日
 * @param <T>
 * @ToDo 
 */
public interface IBaseDao<T> {

	public abstract List<T> query(final int page, final int pageSize) throws IndexOutOfBoundsException,NumberFormatException;
	
	public abstract T getById(final int id) throws Exception;
	
	public abstract List<T> getByProperty(final Map<String,String> obj, final int page, final int pageSize, final boolean isFuzzy)throws Exception;
	
	public abstract List<T> getAll() throws Exception;
	
	public abstract int add(final T t)throws SQLException,NumberFormatException,NullPointerException;
	
	public abstract int update(final T t) throws SQLException,NullPointerException;
	
	public abstract int delete(final T t)throws SQLException,NumberFormatException;
	
	public abstract int countAll() throws Exception;
}
