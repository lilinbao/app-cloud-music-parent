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
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.linbao.api.SessionFactoryRule;

/**
 * @author Linbao
 *
 */
public class MusicTest {

	private static final Integer ART_ID = 1;
	private static final String MUSIC_TITLE = "一次就好";
	
	@Rule
	public SessionFactoryRule sfr = new SessionFactoryRule(new Object[]{new Art(), new Music()});
	
	Session session;
	
	@Before
	public void setUp() throws Exception {
		session = sfr.getSession();
	}

	@Test
	public void testAdd() {
		sfr.beginTransation();
		Music m = createMusic();
		session.save(m);
		sfr.commit();
		assertNotNull(m.getId());
	}
	
	@Test
	public void testLoadById(){
		sfr.beginTransation();
		Music music = this.createMusic();
		Integer id = (Integer) session.save(music);
		music = (Music) session.load(Music.class, id);
		sfr.commit();
		
		assertEquals(music.getTitle(), MUSIC_TITLE);
	}
	
	@Test
	public void testDelete(){
		sfr.beginTransation();
		Music music = this.createMusic();
		Music music2 = this.createMusic();
		
		session.save(music);
		session.save(music2);
		sfr.commit();
		
		assertEquals(2, session.createQuery("from Music").list().size());
		
		sfr.beginTransation();
		session.delete(music);
		sfr.commit();
		assertEquals(1, session.createQuery("from Music").list().size());
	}
	
	@Test
	public void testUpdate(){
		final String title = MUSIC_TITLE + "2";
		sfr.beginTransation();
		Music music = this.createMusic();
		session.save(music);
		sfr.commit();
		
		music.setTitle(title);
		sfr.beginTransation();
		session.save(music);
		sfr.commit();
		music = (Music) session.load(Music.class, 1);
		
		assertEquals(title, music.getTitle());
	}

	private Music createMusic(){
		Music music = new Music();
		Art a = new Art();
		a.setId(ART_ID);
		music.setLocation("Master Land");
		music.setQuantity(2);
		music.setYear("2015");
		music.setTitle(MUSIC_TITLE);
		music.setArt(a);
		session.save(a);
		return music;
	}
	@After
	public void after(){
		//sfr.shutdown();
	}
}
