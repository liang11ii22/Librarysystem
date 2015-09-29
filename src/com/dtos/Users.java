package com.dtos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Depart depart;
	private String name;
	private String password;
	private String tel;
	private String attachment;
	private String bookid;
	private String email;
	private String description;
	private Set returnBorrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Depart depart) {
		this.depart = depart;
	}

	/** full constructor */
	public Users(Depart depart, String name, String password, String tel,
			String attachment, String bookid, String email, String description,
			Set returnBorrows) {
		this.depart = depart;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.attachment = attachment;
		this.bookid = bookid;
		this.email = email;
		this.description = description;
		this.returnBorrows = returnBorrows;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Depart getDepart() {
		return this.depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

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

	public Set getReturnBorrows() {
		return this.returnBorrows;
	}

	public void setReturnBorrows(Set returnBorrows) {
		this.returnBorrows = returnBorrows;
	}

}