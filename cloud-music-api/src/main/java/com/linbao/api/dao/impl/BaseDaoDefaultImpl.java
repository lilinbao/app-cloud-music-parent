/**
 * Dec 6, 2015
 *cloud-music-api
 *TODO The Default for the Project, Set to Hibernate
 *Linbao
 */
package com.linbao.api.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Linbao
 * @param <T>
 *
 */
public class BaseDaoDefaultImpl<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseDaoDefaultImpl.class);

	@Inject
	private SessionFactory sessionFactory;
	protected Session session;
	private static final String FROM = "from ";
	private static final String WHERE = " where ";
	private static final String AND = " and ";
	private static final String OR = " or ";
	private static final String LIKE = " like ";
	private static final String EQUAL = " = ";
	private static final int DEFADULT_PAGE_SIZE = 10;
	private String clazz = null;
	private Query query = null;
	private StringBuilder hql;

	public BaseDaoDefaultImpl() {
		clazz = getGClassName();
	}

	@SuppressWarnings({ "unchecked" })
	private String getGClassName() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		return clazz.getSimpleName().toString();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.dao.IBaseDao#query()
	 */
	@SuppressWarnings("unchecked")
	public List<T> query(final int page, int pageSize) throws IndexOutOfBoundsException, NumberFormatException {
		if(pageSize == 0) pageSize = DEFADULT_PAGE_SIZE;
		hql = new StringBuilder();
		hql.append(FROM).append(clazz);
		query = getSession().createQuery(hql.toString());
		query.setFirstResult(page * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.dao.IBaseDao#getById(int)
	 */
	@SuppressWarnings("unchecked")
	public T getById(final int id) throws Exception {
		hql = new StringBuilder();
		String queryString = "id=  ?";
		hql.append(FROM).append(clazz).append(WHERE).append(queryString);
		query = getSession().createQuery(hql.toString());
		query.setParameter(0, id);
		return (T) query.uniqueResult();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.dao.IBaseDao#getByProperty(java.lang.String,
	 *      java.lang.Object, boolean)
	 */
	@SuppressWarnings("unchecked")
	public List<T> getByProperty(final Map<String, String> obj, final int page, final int pageSize,
			final boolean isFuzzy) throws Exception {
		hql = new StringBuilder();
		hql.append(FROM).append(clazz).append(StringUtils.SPACE);
		if (!obj.isEmpty()) {
			int count = 0;
			Iterator<String> it = obj.keySet().iterator();
			String key = "";
			hql.append(WHERE);
			while(it.hasNext()){
				key = it.next().toString();
				if(isFuzzy){
					if(count != 0) hql.append( OR );
					hql.append( key );
					hql.append( LIKE ).append("'%").append(obj.get(key)).append("%'");
				}else{
					if(count != 0) hql.append( AND );
					hql.append( key );
					hql.append( EQUAL ).append("'").append(obj.get(key)).append("'");
				}
				count ++;
			}
		}
		hql.append(" ; ");
		LOGGER.info(hql.toString());
		query = getSession().createQuery(hql.toString());
		query.setFirstResult(page * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.dao.IBaseDao#getAll()
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() throws Exception {
		hql = new StringBuilder();
		hql.append(FROM).append(clazz);
		LOGGER.info(hql.toString());
		return getSession().createQuery(hql.toString()).list();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.dao.IBaseDao#add(java.lang.Object)
	 */
	public int add(final T t) throws SQLException, NumberFormatException, NullPointerException {
		try {
			getSession().save(t);
			getSession().beginTransaction().commit();
			return 1;
		} catch (Exception e) {
			LOGGER.error("Could not save Entity, {}", e.getMessage());
			return 0;
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.dao.IBaseDao#update(java.lang.Object)
	 */
	public int update(final T t) {
		try {
			getSession().update(t);
			getSession().beginTransaction().commit();
			return 1;
		} catch (Exception e) {
			LOGGER.error("Could not update Entity, {}", e.getMessage());
		}
		return 0;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.linbao.api.dao.IBaseDao#delete(int)
	 */
	public int delete(final T t) {
		try {
			getSession().delete(t);
			getSession().beginTransaction().commit();
			return 1;
		} catch (Exception e) {
			LOGGER.error("Could not delete Entity, {}", e.getMessage());
		}
		return 0;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @throws Exception
	 * @see com.linbao.api.dao.IBaseDao#countAll(java.lang.Object)
	 */
	public int countAll() {

		try {
			return getAll().size();
		} catch (Exception e) {
			LOGGER.error("Nothing was count, {}", e.getMessage());
		}
		return 0;
	}

	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public StringBuilder getHql() {
		return hql;
	}

	protected void setHql(StringBuilder hql) {
		this.hql = hql;
	}
	
}
