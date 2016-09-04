/**
 * Jan 10, 2016
 *cloud-music-api
 *TODO
 *Linbao
 */
package com.linbao.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.TransientObjectException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.linbao.api.SessionFactoryRule;

/**
 * @author Linbao
 *
 */
public class FloderTest {

	@Rule
	public SessionFactoryRule sfr = new SessionFactoryRule(new Object[]{new Floder(), new User(), new Credit()});
	private Session session;
	
	@Before
	public void setUp() throws Exception {
		session = sfr.getSession();
	}
	
	@Test
	public void testGetFolder(){
		sfr.beginTransation();
		Floder floder = new Floder();
		User user = new User();
		user.setEmail("linbaolee@gmail.com");
		user.setPhone("13410018145");
		user.setNickName("Linbao");
		user.setUsername("myusername");
		user.setLevel(1.0);
		floder.setDisplayName("folder name");
		floder.setPath("/path");
		floder.setUser(user);
		session.save(user);
		session.save(floder);
		sfr.commit();
		assertNotNull(floder.getUser().getEmail());
	}
	
	@Test
	public void testAdd() {
		sfr.beginTransation();
		Floder f = new Floder();
		User u = new User();
		u.setId(1);
		f.setDisplayName("Favorite");
		f.setPath("local/music");
		f.setUser(u);
		session.save(u);
		session.save(f);
		sfr.commit();
		
		assertEquals(1, session.createQuery("from Floder").list().size());
	}

	@Test(expected=TransientObjectException.class)
	public void testAddFolderWithoutUser(){
		sfr.beginTransation();
		Floder f = new Floder();
		f.setDisplayName("Favorite");
		f.setPath("local/music");
		f.setUser(new User());
		session.save(f);
		sfr.commit();
	}
	@After
	public void after(){
		
	}
}
