/**
 * Dec 19, 2015
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.linbao.api.dao.impl.UserDaoImpl;
import com.linbao.api.model.User;

/**
 * @author Linbao
 *
 */
public class UserDaoImplTest {

	private static final int PAGE = 1;
	private static final int PAGE_SIZE = 10;
	private static final String EXPECTED_HQL_LIKE = "from User  where id like '%123%' or username like '%Linbao%' ; ";
	private static final String EXPECTED_HQL_EQUAL = "from User  where id = '123' and username = 'Linbao' ; ";
	@Mock
	private SessionFactory sessionFactory;
	@Mock
	private Session session;
	@Mock
	private Query query;
	private UserDaoImpl userDao;
	
	@Before
	public void setUp() throws Exception {
		userDao = new UserDaoImpl();
		MockitoAnnotations.initMocks(this);
		userDao.setSessionFactory(sessionFactory);
		Mockito.when(userDao.getSession()).thenReturn(session);
		Mockito.when(userDao.getSession().createQuery(Mockito.anyString())).thenReturn(query);
	}

	/**
	 * Test method for {@link com.linbao.api.dao.impl.BaseDaoDefaultImpl#query(int, int)}.
	 */
	@Test
	public void testQuery() {
		assertEquals(0,userDao.query(PAGE, 0).size());
		assertEquals(0,userDao.query(PAGE, PAGE_SIZE).size());
	}

	/**
	 * Test method for {@link com.linbao.api.dao.impl.BaseDaoDefaultImpl#getById(int)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetById() throws Exception {
		User user = new User();
		user.setId(1);
		Mockito.when(query.uniqueResult()).thenReturn(user);
		assertNotNull(userDao.getById(1));
	}

	/**
	 * Test method for {@link com.linbao.api.dao.impl.BaseDaoDefaultImpl#getByProperty(java.util.Map, int, int, boolean)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetByProperty() throws Exception {
		Map<String, String> map = new HashMap<String,String>();
		map.put("username", "Linbao");
		map.put("id", "123");
		userDao.getByProperty(map, 1, 0, false);
		assertEquals(EXPECTED_HQL_EQUAL,userDao.getHql().toString());
		userDao.getByProperty(map, 1, 0, true);
		assertEquals(EXPECTED_HQL_LIKE,userDao.getHql().toString());
	}

	/**
	 * Test method for {@link com.linbao.api.dao.impl.BaseDaoDefaultImpl#getAll()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetAll() throws Exception {
		userDao.getAll();
		assertEquals("from User",userDao.getHql().toString());
	}

	/**
	 * Test method for {@link com.linbao.api.dao.impl.BaseDaoDefaultImpl#add(java.lang.Object)}.
	 * @throws SQLException 
	 * @throws NullPointerException 
	 * @throws NumberFormatException 
	 */
	@Test
	public void testAdd() throws NumberFormatException, NullPointerException, SQLException {
		User user = new User();
		user.setId(123);
		user.setNickName("ll");
		user.setUsername("admin");
		assertEquals(0,userDao.add(user));
	}

	/**
	 * Test method for {@link com.linbao.api.dao.impl.BaseDaoDefaultImpl#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(123);
		user.setNickName("ll");
		user.setUsername("admin");
		assertEquals(0,userDao.update(user));
	}

	/**
	 * Test method for {@link com.linbao.api.dao.impl.BaseDaoDefaultImpl#delete(java.lang.Object)}.
	 */
	@Test
	public void testDelete() {
		User user = new User();
		user.setId(123);
		user.setNickName("ll");
		user.setUsername("admin");
		assertEquals(0,userDao.delete(user));
	}

	/**
	 * Test method for {@link com.linbao.api.dao.impl.BaseDaoDefaultImpl#countAll()}.
	 */
	@Test
	public void testCountAll() {
		userDao.countAll();
		assertEquals("from User",userDao.getHql().toString());
	}

}
