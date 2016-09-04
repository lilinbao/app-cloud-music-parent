/**
 * 
 */
package com.linbao.base.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;



import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.linbao.utils.Pager;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月13日
 * @version 2.0
 * @param <T>
 * @ToDo 
 */

public class BaseDaoHibernateImpl<T> {

	private SessionFactory sessionFactory;
	private Session session;
	
	/**
	 * @param sessionFactory
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	private String getGClassName(){
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		return clazz.getSimpleName().toString();
	}
	public BaseDaoHibernateImpl() {
		//this.session = sessionFactory.getCurrentSession();
	}
	/** (non-Javadoc)
	 * @see com.llb.base.IBaseDao#query(java.lang.Object, com.llb.util.Pager)
	 */
	@SuppressWarnings("unchecked")
	public List<T> query(T t, Pager pager) throws IndexOutOfBoundsException,NumberFormatException{
		int offest = 0;
		String sql = "from "+ getGClassName()+" ";
		offest = (pager.getCurrentPage()-1)<= 0 ? 0 : pager.getCurrentPage() * pager.getPageSize() ;
		Query query = this.getSession().createQuery(sql);
		query.setFirstResult(offest);
		query.setMaxResults(pager.getPageSize());
		System.out.println("page size is "+pager.getPageSize());
		System.out.println("offest is "+offest);
		System.out.println("Final SQL is : "+ sql);
		return query.list();
	}

	/** (non-Javadoc)
	 * @see com.llb.base.IBaseDao#getById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public T getById(int id) throws NumberFormatException{
		
		return (T) this.getSession().createQuery("from "+ this.getGClassName()+" where id = ?").setInteger(0, id).uniqueResult();
	}
	/** (non-Javadoc)
	 * @see com.llb.base.IBaseDao#getById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() throws Exception{
		
		return this.getSession().createQuery("from "+ this.getGClassName()).list();
	}

	/** (non-Javadoc)
	 * @see com.llb.base.IBaseDao#add(java.lang.Object)
	 */
	public int add(T t) throws SQLException,NumberFormatException,NullPointerException{
		int b = 0;
		try{
			this.getSession().save(t);
			b = 1;
		}catch(Exception e){
			b = -1;
			//throw e;
		}
		return b;
	}

	/** (non-Javadoc)
	 * @see com.llb.base.IBaseDao#update(java.lang.Object)
	 */
	public int update(T t) throws SQLException,NullPointerException{
		int b = 0;
		try{
			this.getSession().update(t);
			b = 1;
		}catch (Exception e) {
			b = -1;
			//throw e;
		}
		return b;
	}

	/** (non-Javadoc)
	 * @return 
	 * 		1 : delete success
	 * 		0 : no record found in database
	 * @see com.llb.base.BaseDao#delete(java.lang.String)
	 */
	public int delete(int id) throws SQLException,NumberFormatException,NonUniqueObjectException{
		int b = 0;
		T t = this.getById(id);
		if(null != t){
			this.getSession().delete(t);
			b = 1;
		}else {
			b = 0;
			throw new NonUniqueObjectException("Sorry , we can't found the request resource !", this.getGClassName());
		}
		return b;
	}

	public  int countAll(T t) throws Exception{
		
		return this.getSession().createCriteria(this.getGClassName()).list().size();
	}
	
	/** 
	 * @param property
	 * @param value
	 * @param isFuzzy 是否启用模糊查询 
	 * @return ArrayList<T>
	 */
	@SuppressWarnings("unchecked")
	public List<T> getByProperty(String property, Object value,boolean isFuzzy) throws Exception {
		StringBuffer sql = new StringBuffer("from " + this.getGClassName() +" where "+property+" ");
		if(isFuzzy) sql.append(" like :value ");
		else sql.append(" = :value ");
		
		Query query = this.getSession().createQuery(sql.toString());
		
		if(isFuzzy)query.setString("value", "%"+value.toString()+"%");
		else query.setString("value", value.toString());
		System.out.println(sql);
		return query.list();
	}
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		if(null == sessionFactory) {
			Configuration config = new Configuration();
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		//System.out.println("SessionFactory is null :" + (null == sessionFactory));
		//System.out.println("Session is null :" + (null == session));
		if(null == session) this.session = this.getSessionFactory().openSession();
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		session = sessionFactory.getCurrentSession();
	}

}
