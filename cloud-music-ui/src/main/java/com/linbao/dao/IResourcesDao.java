/**
 * 
 */
package com.linbao.dao;

import java.util.List;

import com.linbao.base.IBaseDao;
import com.linbao.model.Resources;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年2月17日
 * @version 2.1
 * @param <Resources>
 * @ToDo 
 */
public interface IResourcesDao extends IBaseDao<Resources> {

	abstract public List<Resources> getResourcesByUser(int userId) throws Exception;
}
