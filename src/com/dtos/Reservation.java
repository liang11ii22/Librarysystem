package com.dtos;


/**
 * Reservation entity. @author MyEclipse Persistence Tools
 */

public class Reservation  {

	// Fields

	private Integer id;
	private SchoolLib schoolLib;
	private Users users;
	private String state;
	private String starttime;
	private String endtime;
	public Reservation(){
		
	}

	
	/** full constructor */
	public Reservation(SchoolLib schoolLib, Users users, String state,
			String starttime, String endtime) {
		this.schoolLib = schoolLib;
		this.users = users;
		this.state = state;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	// Property accessors

	

	public SchoolLib getSchoolLib() {
		return this.schoolLib;
	}

	public void setSchoolLib(SchoolLib schoolLib) {
		this.schoolLib = schoolLib;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}