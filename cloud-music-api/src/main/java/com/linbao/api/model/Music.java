
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
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Music
 * <p>
 * Music Entity Definition
 * 
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "title", "year", "quantity", "location", "art" })
@Table(name="tb_music")
@Entity
public class Music implements Serializable {

	private static final long serialVersionUID = -7327807293335854776L;

	@JsonProperty("id")
	@Id
	@GeneratedValue
	private Integer id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("year")
	private String year;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("location")
	private String location;
	@JsonProperty("art")
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="musics")
	private Art art;

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

	public Music withId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The title
	 */
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param title
	 *            The title
	 */
	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	public Music withTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * 
	 * @return The year
	 */
	@JsonProperty("year")
	public String getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 *            The year
	 */
	@JsonProperty("year")
	public void setYear(String year) {
		this.year = year;
	}

	public Music withYear(String year) {
		this.year = year;
		return this;
	}

	/**
	 * 
	 * @return The quantity
	 */
	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 *            The quantity
	 */
	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Music withQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * 
	 * @return The location
	 */
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location
	 *            The location
	 */
	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	public Music withLocation(String location) {
		this.location = location;
		return this;
	}

	/**
	 * 
	 * @return The art
	 */
	@JsonProperty("art")
	public Art getArt() {
		return art;
	}

	/**
	 * 
	 * @param art
	 *            The art
	 */
	@JsonProperty("art")
	public void setArt(Art art) {
		this.art = art;
	}

	public Music withArt(Art art) {
		this.art = art;
		return this;
	}

}
