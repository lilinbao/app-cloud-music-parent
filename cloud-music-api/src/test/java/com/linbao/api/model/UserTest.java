/**
 * Jan 10, 2016
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.model;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.linbao.api.SessionFactoryRule;

/**
 * @author Linbao
 *
 */
public class UserTest {

	@Rule
	public SessionFactoryRule sfr = new SessionFactoryRule(new Object[]{new User(), new Floder(), new Credit()});
	private static final String EMAIL = "Linbaolee@gmail.com";
	private static final String USER_NAME = "linbao";
	//private static final String PASSWORD = "123";
	private Session session;

	/**
	 * @throws java.lang.Exception
	 *TODO
	 *void
	 */
	@Before
	public void setUp() throws Exception {
		session = sfr.getSession();
	}

	@Test
	public void testSave() {
		sfr.beginTransation();
		User u = new User();
		u.setEmail(EMAIL);
		u.setLevel(1.0);
		u.setNickName(USER_NAME);
		u.setUsername(USER_NAME);
		session.save(u);
		sfr.commit();
		
		assertEquals(1, session.createQuery("from User").list().size());
	}
	
	@After
	public void after(){
		
	}

}
