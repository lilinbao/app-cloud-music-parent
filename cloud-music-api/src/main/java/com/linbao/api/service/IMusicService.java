/**
 * Dec 14, 2015
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.linbao.api.model.Music;

/**
 * @author Linbao
 *
 */
public interface IMusicService {

	public abstract Music getById(final int id) throws Exception;
	
	public abstract List<Music> getByProperty(final Map<String,String> obj, final int page, final int pageSize, final boolean isFuzzy)throws Exception;
	
	public abstract List<Music> getAll() throws Exception;
	
	public abstract int add(final Music music)throws SQLException,NumberFormatException,NullPointerException;
	
	public abstract int update(final Music music) throws SQLException,NullPointerException;
	
	public abstract int delete(final Music music)throws SQLException,NumberFormatException;
}
