/**
 * Jan 10, 2016
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.model;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
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
	//private ApplicationContext ctx;
	private SessionFactory sessionFactory;
	private Session session;
	
	private Configuration configuration;
	
	@Before
	public void setUp() throws Exception {
		//ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//sessionFactory = ctx.getBean("sessionFactory",SessionFactory.class);
		
		configuration = new Configuration();
		configuration.addAnnotatedClass(Floder.class)
					 .addAnnotatedClass(User.class);
		configuration.setProperty("hibernate.dialect",  "org.hibernate.dialect.H2Dialect");
		configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		ServiceRegistry serviceRegistory = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory(serviceRegistory);
	}
	
	@Test
	public void testGetFolder(){
		Floder floder = new Floder();
		User user = new User();
		user.setEmail("linbaolee@gmail.com");
		user.setId(100);
		user.setPhone("13410018145");
		user.setNickName("Linbao");
		user.setUsername("myusername");
		user.setLevel(1.0);
		floder.setDisplayName("folder name");
		floder.setPath("/path");
		floder.setUser(user);
		session = sessionFactory.openSession();
		session.save(floder);
		assertNotNull(floder.getUser().getEmail());
	}
	
	//@Test
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
