package com.linbao.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class SessionFactoryRule implements MethodRule {

	public SessionFactoryRule(Object[] models) {
		super();
		this.models = models;
	}
	private SessionFactory sf = null;
	private Session session = null;
	
	private Transaction transaction = null;
	private Configuration configuration = null;
	
	private Object[] models = null;
	
	@Override
	public Statement apply(final Statement statement, FrameworkMethod method, Object test) {
		return new Statement(){

			@Override
			public void evaluate() throws Throwable {
				sf = createSessionFactory();
				createSession();
				try{
					statement.evaluate();
				}finally{
					shutdown();
				}
			}
		};
	}
	public void shutdown() {
		try{
			try{
				session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			sf.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void beginTransation() {
		transaction = session.beginTransaction();
	}

	private Session createSession() {
		session = sf.openSession();
		return session;
	}

	private SessionFactory createSessionFactory() {
		configuration = new Configuration();
		for(int i = 0; i < models.length; i++){
			configuration.addAnnotatedClass(models[i].getClass());
		}
		//configuration.addAnnotatedClass(Floder.class)
		//			 .addAnnotatedClass(User.class)
		//			 .addAnnotatedClass(Credit.class);
		configuration.setProperty("hibernate.dialect",  "org.hibernate.dialect.H2Dialect");
		configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		ServiceRegistry serviceRegistory = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sf = configuration.configure("hibernate.cfg.xml").buildSessionFactory(serviceRegistory);
		return sf;
	}
	public void commit(){
		transaction.commit();
	}
	
	public Session getSession() {
		return session;
	}
}
