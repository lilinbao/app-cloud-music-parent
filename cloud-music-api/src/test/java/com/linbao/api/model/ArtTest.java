/**
 * Dec 19, 2015
 *cloud-music-api
 *Linbao
 */
package com.linbao.api.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Linbao
 *
 */
public class ArtTest {
	private static final String[] NAMES = {"Linbao","Lishen","Eason"};
	private static final String[] COMPANYS = {"Rock Company","HuaYi Brother Company","LL Company"};
	private static final String[] TYPES = {"Popular","Classical","General"};
	private static final String[] TITLES = {"My Love","Season In The Sun","Huan Huan"};
	private ApplicationContext ctx;
	private SessionFactory sessionFactory;
	private Session session;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		sessionFactory = ctx.getBean("sessionFactory",SessionFactory.class);
	}

	public void testSaveArt() {
		session = sessionFactory.openSession();
		List<Art> arts = createArt(NAMES,COMPANYS,TYPES);
		for(Art a : arts){
			session.save(a);
			List<Music> musics = a.getMusics();
			for(Music m : musics){
				session.save(m);
			}
			session.beginTransaction().commit();
		}
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
