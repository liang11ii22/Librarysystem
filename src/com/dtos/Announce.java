package com.dtos;

/**
 * Announce entity. @author MyEclipse Persistence Tools
 */

public class Announce implements java.io.Serializable {

	// Fields

	private Integer id;
	private Admin admin;
	private String name;
	private String contents;
	private String updatetime;
	

	// Constructors

	/** default constructor */
	public Announce() {
	}

	/** full constructor */
	public Announce(Admin admin, String name, String contents, String updatetime) {
		this.admin = admin;
		this.name = name;
		this.contents = contents;
		this.updatetime = updatetime;
	}

	// Property accessors

	

	public Admin getAdmin() {
		return this.admin;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

}