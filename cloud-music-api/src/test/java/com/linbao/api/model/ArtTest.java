/**
 * Dec 19, 2015
 *cloud-music-api
 *Linbao
 */
package com.linbao.api.model;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.linbao.api.SessionFactoryRule;

/**
 * @author Linbao
 *
 */
public class ArtTest {
	
	@Rule
	public SessionFactoryRule sfr = new SessionFactoryRule(new Object[]{new Art(), new Music()});
	
	private static final String[] NAMES = {"Linbao","Lishen","Eason"};
	private static final String[] COMPANYS = {"Rock Company","HuaYi Brother Company","LL Company"};
	private static final String[] TYPES = {"Popular","Classical","General"};
	private static final String[] TITLES = {"My Love","Season In The Sun","Huan Huan"};
	
	private Session session;

	@Before
	public void setUp() throws Exception {
		session= sfr.getSession();
	}

	@Test
	public void testSaveArt() {
		sfr.beginTransation();
		List<Art> arts = createArt(NAMES,COMPANYS,TYPES);
		for(Art a : arts){
			session.save(a);
			List<Music> musics = a.getMusics();
			for(Music m : musics){
				session.save(m);
			}
		}
		sfr.commit();
		assertEquals(NAMES.length, session.createQuery("from Art").list().size());
		
	}
	
	private List<Art> createArt(final String[] name, final String[] company, final String[] type){
		List<Art> list = new ArrayList<Art>();
		for(int i=0; i< name.length;i++){
			Art a = new Art();
			a.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			a.setCompany(company[i]);
			a.setMusics(createMisucList(TITLES,a,i));
			a.setName(name[i]);
			a.setSex("m");
			a.setType(type[i]);
			list.add(a);
		}
		return list;
	}
	
	private List<Music> createMisucList(final String[] titles,final Art a,final int i){
		List<Music> musics = new ArrayList<Music>();
		for(int j = 0; j < titles.length; j++){
			Music m = new Music();
			m.setTitle(titles[j] + " - " + i);
			m.setLocation("Main Land");
			m.setQuantity(100);
			m.setYear("2015");
			m.setArt(a);
			musics.add(m);
		}
		return musics;
	}
	
}
