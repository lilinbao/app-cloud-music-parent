/**
 * 
 */
package com.linbao.service.impl;

import java.util.List;

import com.linbao.dao.IResourcesDao;
import com.linbao.model.Resources;
import com.linbao.model.User;
import com.linbao.service.IResourcesService;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年2月17日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class ResourcesServiceImpl implements IResourcesService {

	IResourcesDao resourcesDao;
	
	/* (non-Javadoc)
	 * @see com.linbao.service.IReourcesService#getResourcesByUser(com.linbao.model.User)
	 */
	@Override
	public List<Resources> getResourcesByUser(User user) throws Exception {
		
		return resourcesDao.getResourcesByUser(user.getId());
	}

	/**
	 * @return the resourcesDao
	 */
	public IResourcesDao getResourcesDao() {
		return resourcesDao;
	}

	/**
	 * @param resourcesDao the resourcesDao to set
	 */
	public void setResourcesDao(IResourcesDao resourcesDao) {
		this.resourcesDao = resourcesDao;
	}

}
