/**
 * 
 */
package com.linbao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Linbao.Lee@gmail.com
 * @time 2013年12月18日
 * @version 2.0
 * @param <T>
 * @ToDo 
 */
@Entity
@Table(name="tb_role")
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int roleLevel;
	private String name;
	private String description;
	private Set<Resources> resources = new HashSet<Resources>(0);
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the level
	 */
	public int getRoleLevel() {
		return roleLevel;
	}
	/**
	 * @param level the level to set
	 */
	public void setRoleLevel(int level) {
		this.roleLevel = level;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the resources
	 */
	@ManyToMany
	@JoinTable(name="tb_role_resource",
		joinColumns={@JoinColumn(name="role_id",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="res_id",referencedColumnName="id")}
	)
	public Set<Resources> getResources() {
		return resources;
	}
	/**
	 * @param resources the resources to set
	 */
	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}
	
}
