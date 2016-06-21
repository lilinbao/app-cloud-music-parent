/**
 * Jan 10, 2016
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Linbao
 *
 */
public class UserTest {

	private static final String EMAIL = "Linbaolee@gmail.com";
	private static final String USER_NAME = "linbao";
	private static final String PASSWORD = "123";
	private ApplicationContext ctx;
	private SessionFactory sessionFactory;
	private Session session;

	/**
	 * @throws java.lang.Exception
	 *TODO
	 *void
	 */
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		sessionFactory = ctx.getBean("sessionFactory",SessionFactory.class);
	}

	@Test
	public void testSave() {
		User u = new User();
		u.setEmail(EMAIL);
		u.setLevel(1.0);
		u.setNickName(USER_NAME);
		u.setUsername(USER_NAME);
		session = sessionFactory.openSession();
		session.save(u);
		session.beginTransaction().commit();
	}
	
	@After
	public void after(){
		session.close();
	}

}
