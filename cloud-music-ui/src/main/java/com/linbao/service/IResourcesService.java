/**
 * 
 */
package com.linbao.service;

import java.util.List;

import com.linbao.model.Resources;
import com.linbao.model.User;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年2月17日
 * @version 2.1
 * @param <Resources>
 * @ToDo 
 */
public interface IResourcesService {

	public abstract List<Resources> getResourcesByUser(User user) throws Exception;
}
