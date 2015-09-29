package com.dtos;

import java.math.BigDecimal;

/**
 * ReturnBorrow entity. @author MyEclipse Persistence Tools
 */

public class ReturnBorrow implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Users users;
	private Book book;
	private String bdate;
	private String rdate;
	private String shouldRdate;

	// Constructors

	/** default constructor */
	public ReturnBorrow() {
	}

	/** minimal constructor */
	public ReturnBorrow(Users users, Book book) {
		this.users = users;
		this.book = book;
	}

	/** full constructor */
	public ReturnBorrow(Users users, Book book, String bdate, String rdate,
			String shouldRdate) {
		this.users = users;
		this.book = book;
		this.bdate = bdate;
		this.rdate = rdate;
		this.shouldRdate = shouldRdate;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getBdate() {
		return this.bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getRdate() {
		return this.rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getShouldRdate() {
		return this.shouldRdate;
	}

	public void setShouldRdate(String shouldRdate) {
		this.shouldRdate = shouldRdate;
	}

}