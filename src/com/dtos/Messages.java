package com.dtos;

import java.math.BigDecimal;

/**
 * Messages entity. @author MyEclipse Persistence Tools
 */

public class Messages implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private String name;
	private String contents;
	private String MDate;
	private String descp;

	// Constructors

	/** default constructor */
	public Messages() {
	}

	/** full constructor */
	public Messages(Users users, String name, String contents, String MDate,
			String descp) {
		this.users = users;
		this.name = name;
		this.contents = contents;
		this.MDate = MDate;
		this.descp = descp;
	}

	// Property accessors

	
	public Users getUsers() {
		return this.users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getMDate() {
		return this.MDate;
	}

	public void setMDate(String MDate) {
		this.MDate = MDate;
	}

	public String getDescp() {
		return this.descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

}