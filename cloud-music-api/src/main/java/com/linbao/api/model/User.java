
package com.linbao.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * User
 * <p>
 * User Entity Definition
 * 
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "username", "email", "level", "floders", "credit" })
@Table(name="tb_user")
@Entity
public class User implements Serializable{

	
	private static final long serialVersionUID = -8910790043445672059L;
	
	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("username")
	private String username;
	@JsonProperty("email")
	private String email;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("nickName")
	private String nickName;
	@JsonProperty("level")
	private Double level;
	@JsonProperty("floders")
	@JsonManagedReference
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<Floder> floders = new ArrayList<Floder>();
	@JsonProperty("credit")
	@JsonManagedReference
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Credit> credit = new ArrayList<Credit>(0);
	
	/**
	 * 
	 * @return The id
	 */
	@JsonProperty("id")
	public Object getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	public User withId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * 
	 * @return The username
	 */
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 *            The username
	 */
	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	public User withUsername(String username) {
		this.username = username;
		return this;
	}

	/**
	 * 
	 * @return The email
	 */
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 *            The email
	 */
	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	public User withEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * 
	 * @return The level
	 */
	@JsonProperty("level")
	public Double getLevel() {
		return level;
	}

	/**
	 * 
	 * @param level
	 *            The level
	 */
	@JsonProperty("level")
	public void setLevel(Double level) {
		this.level = level;
	}

	public User withLevel(Double level) {
		this.level = level;
		return this;
	}

	/**
	 * 
	 * @return The floders
	 */
	@JsonProperty("floders")
	public List<Floder> getFloders() {
		return floders;
	}

	/**
	 * 
	 * @param floders
	 *            The floders
	 */
	@JsonProperty("floders")
	public void setFloders(List<Floder> floders) {
		this.floders = floders;
	}

	public User withFloders(List<Floder> floders) {
		this.floders = floders;
		return this;
	}

	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty("nickName")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@JsonProperty("credit")
	public List<Credit> getCredit() {
		return credit;
	}

	public void setCredit(List<Credit> credit) {
		this.credit = credit;
	}
	

}
