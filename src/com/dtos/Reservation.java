package com.dtos;

/**
 * Reservation entity. @author MyEclipse Persistence Tools
 */

public class Reservation  {

	// Fields

	private Integer id;
	private SchoolLib schoolLib;
	private Users users;
	private String seat;
	public String getSeat() {
		return seat;
	}


	public void setSeat(String seat) {
		this.seat = seat;
	}

	private String state;
	private String period;// morning/afternoon/evening
	private String time; //yy/mm/dd
	private int version;
	
	public Reservation(){
		
	}

	
	/** full constructor */
	public Reservation(SchoolLib schoolLib, Users users, String seat, String state,
			String period, String time, int version) {
		this.schoolLib = schoolLib;
		this.users = users;
		this.seat = seat;
		this.state = state;
		this.period = period;
		this.time = time;
		this.version = version;
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

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
