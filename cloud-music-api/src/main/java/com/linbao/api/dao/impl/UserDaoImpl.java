/**
 * Dec 13, 2015
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.dao.impl;

import org.springframework.stereotype.Component;

import com.linbao.api.dao.IUserDao;
import com.linbao.api.model.User;

/**
 * @author Linbao
 *
 */
@Component("userDao")
public  class UserDaoImpl extends BaseDaoDefaultImpl<User> implements IUserDao{
	
}
