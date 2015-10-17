package com.dtos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users{

	// Fields

	private Integer id;
	//private Depart depart;
	private String name;
	private String password;
	private String tel;
	private String attachment;
	private String bookid;
	private String email;
	private String description;
	private Set borrowreturn = new HashSet(0);
	private Set bookcomms = new HashSet(0);
	private Set message = new HashSet(0);
	private Set reservations = new HashSet(0);


	// Constructors

	/** default constructor */
	public Users() {
	}

	

	/** full constructor */
	public Users(String name, String password, String tel,
			String attachment, String bookid, String email, String description,Set borrowreturn, Set bookcomms, Set message,Set reservations) {
		//this.depart = depart;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.attachment = attachment;
		this.bookid = bookid;
		this.email = email;
		this.description = description;
		this.borrowreturn = borrowreturn;
		this.bookcomms = bookcomms;
		this.message = message;
		this.reservations = reservations;
	}

	// Property accessors

	

//	public Depart getDepart() {
//		return this.depart;
//	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}


//
//	public void setDepart(Depart depart) {
//		this.depart = depart;
//	}

	public String getName() {
		return this.name;
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

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getBookid() {
		return this.bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Set getBorrowreturn() {
		return borrowreturn;
	}



	public void setBorrowreturn(Set borrowreturn) {
		this.borrowreturn = borrowreturn;
	}



	public Set getBookcomms() {
		return bookcomms;
	}



	public void setBookcomms(Set bookcomms) {
		this.bookcomms = bookcomms;
	}



	public Set getMessage() {
		return message;
	}



	public void setMessage(Set message) {
		this.message = message;
	}



	public Set getReservations() {
		return reservations;
	}



	public void setReservations(Set reservations) {
		this.reservations = reservations;
	}

}