/**
 * Dec 8, 2015
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * @author Linbao
 *
 */
public class HibernateSchemaExportTest {

	public static LocalSessionFactoryBean localSessionFactory = null;
	
	@BeforeClass
	public static void beforeClass(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		localSessionFactory = (LocalSessionFactoryBean) ctx.getBean("&sessionFactory");
	}
	@Test
	public void testSchemaEcport(){
		
		Configuration conf = localSessionFactory.getConfiguration();
		new SchemaExport(conf).create(true,true);
		//new SchemaExport(conf).drop(true, true);
	}
	@AfterClass
	public static void destroy(){
		localSessionFactory.destroy();
	}
	

}
