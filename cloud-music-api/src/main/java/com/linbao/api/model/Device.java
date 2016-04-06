package com.linbao.api.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "device")
public class Device implements Serializable {

	/**
	 * @author Linbao
	 */
	private static final long serialVersionUID = 100839L;

	private String ip;

	private String name;

	public Device() {

	}

	public Device(String ip) {

		this.ip = ip;
	}

	@XmlAttribute
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
