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
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Linbao
 *
 */
public class FloderTest {

	/**
	 * @throws java.lang.Exception
	 *TODO
	 *void
	 */
	private ApplicationContext ctx;
	private SessionFactory sessionFactory;
	private Session session;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		sessionFactory = ctx.getBean("sessionFactory",SessionFactory.class);
	}

	@Test
	public void testAdd() {
		Floder f = new Floder();
		User u = new User();
		u.setId(1);
		f.setDisplayName("Favorite");
		f.setPath("local/music");
		f.setUser(u);
		session = sessionFactory.openSession();
		session.save(f);
		session.beginTransaction().commit();
	}

	@After
	public void after(){
		session.close();
	}
}
