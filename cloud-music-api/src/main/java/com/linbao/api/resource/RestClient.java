package com.linbao.api.resource;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestClient {

	private String resource;
	private Client client;
	
	public RestClient() {
		if(client == null){
			ClientConfig config = new DefaultClientConfig();
			config.getClasses().add(JacksonJsonProvider.class);
			client = Client.create(config);
		}
	}
	
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public Client getClient() {
		
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
