package com.linbao.api;


import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class CloudMusicApplication extends ResourceConfig {

	public CloudMusicApplication(){
		packages(MyResource.class.getPackage().getName());
		register(JacksonJsonProvider.class);
		
	}
}