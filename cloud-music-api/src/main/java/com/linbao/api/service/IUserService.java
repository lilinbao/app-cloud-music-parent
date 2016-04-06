package com.linbao.api.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.linbao.api.model.User;

public interface IUserService {

public abstract List<User> query(final int page, final int pageSize) throws IndexOutOfBoundsException,NumberFormatException;
	
	public abstract User getById(final int id) throws Exception;
	
	public abstract List<User> getByProperty(final Map<String,String> obj, final int page, final int pageSize, final boolean isFuzzy)throws Exception;
	
	public abstract List<User> getAll() throws Exception;
	
	public abstract int add(final User user)throws SQLException,NumberFormatException,NullPointerException;
	
	public abstract int update(final User user) throws SQLException,NullPointerException;
	
	public abstract int delete(final User user)throws SQLException,NumberFormatException;
}
