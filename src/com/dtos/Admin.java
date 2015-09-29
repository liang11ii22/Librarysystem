package com.dtos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String description;
	private String attachment;
	private String brief;
	private Set announces = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String name, String password, String description,
			String attachment, String brief, Set announces) {
		this.name = name;
		this.password = password;
		this.description = description;
		this.attachment = attachment;
		this.brief = brief;
		this.announces = announces;
	}

	// Property accessors

	

	public String getName() {
		return this.name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Set getAnnounces() {
		return this.announces;
	}

	public void setAnnounces(Set announces) {
		this.announces = announces;
	}

}