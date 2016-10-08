/**
 * 
 */
package com.linbao.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.linbao.base.impl.BaseDaoHibernateImpl;
import com.linbao.dao.IResourcesDao;
import com.linbao.model.Resources;
import com.linbao.model.Role;
import com.linbao.model.User;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2014年2月17日
 * @version 2.1
 * @param <T>
 * @ToDo 
 */
public class ResourcesDaoImpl extends BaseDaoHibernateImpl<Resources> implements IResourcesDao {
	/* (non-Javadoc)
	 * @see com.llb.dao.IRsourcesDao#getResourcesByUser()
	 */
	@Override
	public List<Resources> getResourcesByUser(int userId) throws Exception {
		List<Resources> list = new ArrayList<Resources>();
		User u = new User(userId);
		Set<Role> roles = u.getRoles();
		if(null != roles){
			for(Role r : roles){
				for(Resources res : r.getResources()){
					list.add(res);
				}
			}
		}
		return list;
	}

}
