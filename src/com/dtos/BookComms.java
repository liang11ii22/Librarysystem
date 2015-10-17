package com.dtos;

import java.util.HashSet;
import java.util.Set;

/**
 * BookComms entity. @author MyEclipse Persistence Tools
 */

public class BookComms {

	// Fields

	private Integer id;
	private Book book;
	private BookComms bookComms;
	private Users users;
	private String commcontents;
	private String commdate;
	private Set bookCommses = new HashSet(0);

	// Constructors

	/** default constructor */
	public BookComms() {
	}

	/** full constructor */
	public BookComms(Book book, BookComms bookComms, Users users,
			String commcontents, String commdate, Set bookCommses) {
		this.book = book;
		this.bookComms = bookComms;
		this.users = users;
		this.commcontents = commcontents;
		this.commdate = commdate;
		this.bookCommses = bookCommses;
	}

	// Property accessors

	
	public Book getBook() {
		return this.book;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookComms getBookComms() {
		return this.bookComms;
	}

	public void setBookComms(BookComms bookComms) {
		this.bookComms = bookComms;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCommcontents() {
		return this.commcontents;
	}

	public void setCommcontents(String commcontents) {
		this.commcontents = commcontents;
	}

	public String getCommdate() {
		return this.commdate;
	}

	public void setCommdate(String commdate) {
		this.commdate = commdate;
	}

	public Set getBookCommses() {
		return this.bookCommses;
	}

	public void setBookCommses(Set bookCommses) {
		this.bookCommses = bookCommses;
	}

}