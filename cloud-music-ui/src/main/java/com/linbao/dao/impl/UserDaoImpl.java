/**
 * 
 */
package com.linbao.dao.impl;

import org.hibernate.criterion.Restrictions;

import com.linbao.base.impl.BaseDaoHibernateImpl;
import com.linbao.dao.IUserDao;
import com.linbao.model.User;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月3日 
 * @version 2.0
 * @param <T>
 * @ToDo 
 */
public class UserDaoImpl extends BaseDaoHibernateImpl<User> implements IUserDao{

	/* (non-Javadoc)
	 * @see com.llb.dao.UserDao#isExist(java.lang.String)
	 */
	@Override
	public boolean isExist(String username) throws Exception {

		User user = null;
		user = (User) this.getSession().createCriteria(User.class)
					.add(Restrictions.eq("username", username))
					.uniqueResult();
		if(null != user)
			return true;
		else 
			return false;
	}

	/** (non-Javadoc)
	 * @see com.llb.dao.IUserDao#countUser(java.lang.String, java.lang.String)
	 * @return 0:Can not found the user;
	 * @return 1:Password invalid;
	 * @return 2:User on file
	 */
	@Override
	public User countUser(String username, String password) throws Exception {
		//int flag = 0;
		User user = null;
		user = (User) this.getSession().createCriteria(User.class)
										.add(Restrictions.eq("username", username))
										.add(Restrictions.eq("password", password))
										.uniqueResult();
		//if(null == password || !(password.equals(user.getPassword()))) flag = 1;
		//else if (password.equals(user.getPassword())) flag = 2;
		return user;
	}

	

	
}
