
package com.linbao.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "name", "sex", "type", "birthday", "company" })
@Table(name = "tb_art")
@Entity
public class Art implements Serializable {

	private static final long serialVersionUID = -186317883947101901L;

	@JsonProperty("id")
	@Id
	@GeneratedValue
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("sex")
	private String sex;
	@JsonProperty("type")
	private String type;
	@JsonProperty("birthday")
	private String birthday;
	@JsonProperty("company")
	private String company;
	@OneToMany(mappedBy = "art")
	@JsonManagedReference
	private List<Music> musics = new ArrayList<Music>(0);

	/**
	 * (Required)
	 * @return The id
	 */
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	/**
	 * (Required)
	 * @param id
	 *            The id
	 */
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	public Art withId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * (Required)
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * (Required)
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Art withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @return The sex
	 */
	@JsonProperty("sex")
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            The sex
	 */
	@JsonProperty("sex")
	public void setSex(String sex) {
		this.sex = sex;
	}

	public Art withSex(String sex) {
		this.sex = sex;
		return this;
	}

	/**
	 * @return The type
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            The type
	 */
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	public Art withType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * @return The birthday
	 */
	@JsonProperty("birthday")
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            The birthday
	 */
	@JsonProperty("birthday")
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Art withBirthday(String birthday) {
		this.birthday = birthday;
		return this;
	}

	/**
	 * @return The company
	 */
	@JsonProperty("company")
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            The company
	 */
	@JsonProperty("company")
	public void setCompany(String company) {
		this.company = company;
	}

	public Art withCompany(String company) {
		this.company = company;
		return this;
	}

	/**
	 * @return List<Music>
	 */
	@JsonProperty("musics")
	@JsonIgnore
	public List<Music> getMusics() {
		return musics;
	}

	/**
	 * @param musics
	 *            void
	 */
	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
}
