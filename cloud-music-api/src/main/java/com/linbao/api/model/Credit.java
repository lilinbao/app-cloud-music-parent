
package com.linbao.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
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

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "name", "creditAmount", "createTime", "effectedTime", "endTime" })
@Table(name = "tb_credit")
@Entity
public class Credit implements Serializable {

	private static final long serialVersionUID = -3476905155298342717L;

	@JsonProperty("id")
	@Id
	@GeneratedValue
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("creditAmount")
	private BigDecimal creditAmount;
	@JsonProperty("createTime")
	private Date createTime;
	@JsonProperty("effectedTime")
	private Date effectedTime;
	@JsonProperty("endTime")
	private Date endTime;
	@ManyToOne(cascade={CascadeType.MERGE})
	@JsonBackReference
	@JoinColumn(name="user_id")
	private User user;

	/**
	 * 
	 * @return The id
	 */
	@JsonProperty("id")
	public Integer getId() {
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

	public Credit withId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Credit withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 
	 * @return The creditAmount
	 */
	@JsonProperty("creditAmount")
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	/**
	 * 
	 * @param creditAmount
	 *            The creditAmount
	 */
	@JsonProperty("creditAmount")
	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Credit withCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
		return this;
	}

	/**
	 * 
	 * @return The createTime
	 */
	@JsonProperty("createTime")
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 
	 * @param createTime
	 *            The createTime
	 */
	@JsonProperty("createTime")
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Credit withCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	/**
	 * 
	 * @return The effectedTime
	 */
	@JsonProperty("effectedTime")
	public Date getEffectedTime() {
		return effectedTime;
	}

	/**
	 * 
	 * @param effectedTime
	 *            The effectedTime
	 */
	@JsonProperty("effectedTime")
	public void setEffectedTime(Date effectedTime) {
		this.effectedTime = effectedTime;
	}

	public Credit withEffectedTime(Date effectedTime) {
		this.effectedTime = effectedTime;
		return this;
	}

	/**
	 * 
	 * @return The endTime
	 */
	@JsonProperty("endTime")
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 
	 * @param endTime
	 *            The endTime
	 */
	@JsonProperty("endTime")
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Credit withEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
