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
public class MusicTest {

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
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = ctx.getBean("sessionFactory",SessionFactory.class);
	}

	@Test
	public void testAdd() {
		Music m = new Music();
		Art a = new Art();
		a.setId(1);
		m.setLocation("Master Land");
		m.setQuantity(2);
		m.setYear("2015");
		m.setTitle("一次就好");
		m.setArt(a);
		session = sessionFactory.openSession();
		session.save(m);
		session.beginTransaction().commit();
	}

	@After
	public void after(){
		session.close();
	}
}
