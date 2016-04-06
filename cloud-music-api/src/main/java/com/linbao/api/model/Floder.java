
package com.linbao.api.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Floder
 * <p>
 * Folder Entity Definition
 * 
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "displayName", "path" ,"user" })
@Table(name="tb_floder")
@Entity
public class Floder implements Serializable{

	private static final long serialVersionUID = 2130561468492242521L;
	
	@JsonProperty("id")
	@Id
	@GeneratedValue
	private Integer id;
	@JsonProperty("displayName")
	private String displayName;
	@JsonProperty("path")
	private String path;
	@JsonProperty("user")
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="user_id")
	private User user;
	/**
	 * 
	 * (Required)
	 * 
	 * @return The id
	 */
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param id
	 *            The id
	 */
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	public Floder withId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The displayName
	 */
	@JsonProperty("displayName")
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param displayName
	 *            The displayName
	 */
	@JsonProperty("displayName")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Floder withDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	/**
	 * 
	 * @return The path
	 */
	@JsonProperty("path")
	public String getPath() {
		return path;
	}

	/**
	 * 
	 * @param path
	 *            The path
	 */
	@JsonProperty("path")
	public void setPath(String path) {
		this.path = path;
	}

	public Floder withPath(String path) {
		this.path = path;
		return this;
	}

	/**
	 * 
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 *            The user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 
	 * @param user
	 *            The User
	 */
	public Floder withUser(User user){
		this.user = user;
		return this;
	}
}
