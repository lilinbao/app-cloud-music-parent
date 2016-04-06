
package com.linbao.api.resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linbao.api.model.Art;
import com.linbao.api.model.Music;
import com.linbao.api.model.support.ResponseWrapper;
import com.linbao.api.service.IMusicService;

/**
 * Resource interface of Music
 *
 */
@Path("musics")
public class MusicsResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(MusicsResource.class);
	@Inject
	private IMusicService musicService;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response sayHello(@PathParam("id") String id) throws Exception{
		Integer intId = Integer.valueOf(id.substring(1));
		Art a = new Art();
		a.setId(1);
		a.setBirthday("19890622");
		a.setCompany("滚石唱片公司");
		a.setName("陈奕迅");
		a.setSex("男");
		a.setType("流行");
		Music m = new Music();
		m.setId(intId);
		m.setArt(a);
		m.setLocation("大陆");
		m.setQuantity(2);
		m.setTitle("浮夸");
		m.setYear("2015");
		return ResponseWrapper.withJsonOK(m);
	}

	/**
	 * This requests require authentication
	 *
	 * @param accessToken
	 *
	 */
	@POST
	@Consumes("multipart/form-data")
	@Produces({ "application/json" })
	public Response postMusics(@HeaderParam("access_token") String accessToken, Music entity) throws Exception{
		return ResponseWrapper.withJsonCreated(null);
	}

	/**
	 * To edit or update a Music
	 *
	 * @param accessToken
	 *
	 */
	@PUT
	@Consumes("multipart/form-data")
	public Response putMusics(@HeaderParam("access_token") String accessToken, Music entity) throws Exception{
		return ResponseWrapper.ok(null).build();
	}

	/**
	 * Delete a Music by given id
	 *
	 * @param id
	 *            The identification of Music
	 */
	@DELETE
	@Produces({ "application/json" })
	public Response deleteMusics(@QueryParam("id") String id) throws Exception{
		return ResponseWrapper.ok().build();
	}

	/**
	 * Get Music object
	 *
	 * @param id
	 *            The identification of the Music
	 */
	@GET
	public Response getMusics(@QueryParam("id") String id) throws Exception{
		return ResponseWrapper.withJsonOK(new ArrayList<Music>().add(new Music()));
	}

	/**
	 * get collection of Music
	 *
	 * @param limit
	 *            The number of items per page
	 * @param page
	 *            The page to be requested
	 */
	@GET
	@Path("list")
	@Produces({ "application/json" })
	public Response getMusicsList(@QueryParam("page") @DefaultValue("1") long page,
			@QueryParam("limit") @DefaultValue("10") long limit) throws Exception{
		List<Music> list = new ArrayList<Music>();
		return ResponseWrapper.withJsonOK(list);
	}

	/**
	 * Specify the page that you want to retrieve
	 *
	 * @param limit
	 *            The number of items per page
	 * @param page
	 *            The page to be requested
	 * @param title
	 *
	 */
	@GET
	@Path("search")
	@Produces({ "application/json" })
	public Response getMusicsSearch(@QueryParam("title") String title, @QueryParam("page") @DefaultValue("1") long page,
			@QueryParam("limit") @DefaultValue("10") long limit) throws Exception{
		List<Music> list = new ArrayList<Music>();
		return ResponseWrapper.withJsonOK(list);
	}

	/**
	 *
	 * @param id
	 *            Uri parameter, path parameter start with m will take the call
	 *            into this method
	 */
	@GET
	@Path("{id:m\\d{3,5}}")
	@Produces({ "application/json" })
	public Response getMusicsByIdMDBy35(@PathParam("id") String id) throws Exception{
		return ResponseWrapper.withJsonOK(new Music());
	}

	/**
	 *
	 * @param art
	 *            Uri parameter, path parameter start with a will take the call
	 *            into this method
	 */
	@GET
	@Path("{art:a\\d{3,5}}")
	@Produces({ "application/json" })
	public Response getMusicsByArtADBy35(@PathParam("art") String art) throws Exception{
		List<Music> list = new ArrayList<Music>();
		return ResponseWrapper.withJsonOK(list);
	}

	/**
	 *
	 * @param year
	 *            Uri parameter, path parameter start with y will take the call
	 *            into this method
	 */
	@GET
	@Path("{year:y\\d{3,5}}")
	@Produces({ "application/json" })
	public Response getMusicsByYearYDBy35(@PathParam("year") String year) throws Exception{
		List<Music> list = new ArrayList<Music>();
		return ResponseWrapper.withJsonOK(list);
	}

	/**
	 *
	 * @param style
	 *            Uri parameter, path parameter start with s will take the call
	 *            into this method
	 */
	@GET
	@Path("{style:s\\d?}")
	@Produces({ "application/json" })
	public Response getMusicsByStyleSD(@PathParam("style") String style) throws Exception{
		List<Music> list = new ArrayList<Music>();
		return ResponseWrapper.withJsonOK(list);
	}

	public IMusicService getMusicService() {
		return musicService;
	}

	public void setMusicService(IMusicService musicService) {
		this.musicService = musicService;
	}
	
}
