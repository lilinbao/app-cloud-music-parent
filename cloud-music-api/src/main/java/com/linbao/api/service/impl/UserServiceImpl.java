/**
 * Dec 13, 2015
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.linbao.api.dao.IUserDao;
import com.linbao.api.model.User;
import com.linbao.api.service.IUserService;

/**
 * @author Linbao
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Inject
	IUserDao userDao;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.service.IUserService#query(int, int)
	 */
	@Override
	public List<User> query(final int page, final int pageSize)
			throws IndexOutOfBoundsException, NumberFormatException {

		return userDao.query(page, pageSize);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.service.IUserService#getById(int)
	 */
	@Override
	public User getById(final int id) throws Exception {

		return userDao.getById(id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.service.IUserService#getByProperty(java.util.Map, int,
	 *      int, boolean)
	 */
	@Override
	public List<User> getByProperty(final Map<String, String> obj, final int page, final int pageSize,
			final boolean isFuzzy) throws Exception {
		return userDao.getByProperty(obj, page, pageSize, isFuzzy);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.service.IUserService#getAll()
	 */
	@Override
	public List<User> getAll() throws Exception {
		return userDao.getAll();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.service.IUserService#add(com.linbao.api.model.User)
	 */
	@Override
	public int add(final User user) throws SQLException, NumberFormatException, NullPointerException {

		return userDao.add(user);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.service.IUserService#update(com.linbao.api.model.User)
	 */
	@Override
	public int update(final User user) throws SQLException, NullPointerException {

		return userDao.update(user);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.service.IUserService#delete(com.linbao.api.model.User)
	 */
	@Override
	public int delete(final User user) throws SQLException, NumberFormatException {

		return userDao.delete(user);
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(final IUserDao userDao) {
		this.userDao = userDao;
	}

}
