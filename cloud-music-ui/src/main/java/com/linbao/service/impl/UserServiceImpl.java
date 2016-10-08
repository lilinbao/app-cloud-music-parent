/**
 * 
 */
package com.linbao.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.NonUniqueObjectException;

import com.linbao.dao.IResourcesDao;
import com.linbao.dao.IUserDao;
import com.linbao.exception.InvalidInputException;
import com.linbao.model.Resources;
import com.linbao.model.Role;
import com.linbao.model.User;
import com.linbao.service.IUserService;
import com.linbao.utils.Pager;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月5日
 * @version 2.0
 * @param <T>
 * @ToDo 
 */
public class UserServiceImpl implements IUserService{

	private IUserDao userDao;
	private IResourcesDao resourcesDao;
	private int pageSize;
	/* (non-Javadoc)
	 * @see com.linbao.service.UserService#isExistUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User isExistUser(String username, String password) throws Exception {
		return userDao.countUser(username, password);
	}
	
	/* (non-Javadoc)
	 * @see com.linbao.service.IUserService#add(com.linbao.model.User)
	 */
	@Override
	public int add(User user) throws SQLException,NumberFormatException,NullPointerException {
		int result = 0;
		if(null == user || "".equals(user.getUsername()) || "".equals(user.getPassword())) {
			result = 0;
			if(null == user) throw new NullPointerException("user");
			else if("".equals(user.getUsername()));//throw new InvalidInputException("username");
			else if("".equals(user.getPassword())) ;//throw new InvalidInputException("password");
		}
		else {
			result = userDao.add(user);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.linbao.service.UserService#getById()
	 */
	@Override
	public User getById(int id) {
		User user  = null;
		try {
			user = userDao.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see com.linbao.service.IUserService#delete(com.linbao.model.User)
	 */
	@Override
	public int delete(User user) throws SQLException,NumberFormatException,NonUniqueObjectException{
		
		return userDao.delete(user.getId());
	}

	/* (non-Javadoc)
	 * @see com.linbao.service.IUserService#update(com.linbao.model.User)
	 */
	@Override
	public int update(User user) throws SQLException,InvalidInputException,NullPointerException{
		// TODO Auto-generated method stub
		int result = 0;
		result =  userDao.update(user);
		return result;
	}
	/* (non-Javadoc)
	 * @see com.linbao.service.UserService#getByGroup(int)
	 */
	@Override
	public List<User> getByRole(int RoleId) throws NullPointerException,NumberFormatException {
		List<User> list = new ArrayList<User>();
		try {
			list = userDao.getByProperty("role", RoleId, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.linbao.service.UserService#getByPage(com.linbao.util.Pager)
	 */
	@Override
	public List<User> getByPage(Pager pager) throws IndexOutOfBoundsException,NumberFormatException {
		if(null == pager){
			pager = new Pager(0,0,0);
		}
		User user = new User();
		if(pager.getCurrentPage() == 0)  pager.setCurrentPage(1);
		if(pager.getPageSize() == 0) pager.setPageSize(this.getPageSize());
		
		return userDao.query(user, pager);
	}

	

	/* (non-Javadoc)
	 * @see com.linbao.service.IUserService#getByName(java.lang.String)
	 */
	@Override
	public List<User> getByName(String name) throws Exception {
		
		return userDao.getByProperty("name", name, false);
	}

	/* (non-Javadoc)
	 * @see com.linbao.service.IUserService#getByUserName(java.lang.String)
	 */
	@Override
	public List<User> getByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getByProperty("username", userName, false);
	}

	/* (non-Javadoc)
	 * @see com.linbao.service.IUserService#getAll()
	 */
	@Override
	public List<User> getAll() throws Exception {
				
		return userDao.getAll();
	}

	/** (non-Javadoc)
	 * @see com.linbao.service.IUserService#getByEmail(java.lang.String)
	 * @param email address (String)
	 * @throws Exception 
	 */
	@Override
	public List<User> getByEmail(String email) throws Exception {

		return userDao.getByProperty("email", email, false);
	}

	/* (non-Javadoc)
	 * @see com.linbao.dao.IRsourcesDao#getResourcesByUser()
	 */
	@Override
	public List<Resources> getResourcesByUser(int userId) throws Exception {
		List<Resources> list = new ArrayList<Resources>();
		User u = userDao.getById(userId);
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
	/**
	 * @return the userDao
	 */
	public IUserDao getUserDao() {
		return userDao;
	}
	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		if(0 == this.pageSize) this.pageSize = 20;
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
