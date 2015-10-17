package com.dtos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category category;
	private SchoolLib schoolLib;
	private String name;
	private String descp;
	private String author;
	private String publishment;
	private String attachment;
	private String brief;
	private String publishdate;
	private Integer totalbook;
	private Set borrowreturn = new HashSet(0);
	private Set bookcomms = new HashSet(0);

	//private Set returnBorrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(Category category, SchoolLib schoolLib, String name,
			String descp, String author, String publishment, String attachment,
			String brief, String publishdate, Integer totalbook, Set borrowreturn, Set bookcomms) {
		this.category = category;
		this.schoolLib = schoolLib;
		this.name = name;
		this.descp = descp;
		this.author = author;
		this.publishment = publishment;
		this.attachment = attachment;
		this.brief = brief;
		this.publishdate = publishdate;
		this.totalbook = totalbook;
		this.borrowreturn = borrowreturn;
		this.bookcomms = bookcomms;
		
	}

	// Property accessors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	public SchoolLib getSchoolLib() {
		return this.schoolLib;
	}

	public void setSchoolLib(SchoolLib schoolLib) {
		this.schoolLib = schoolLib;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescp() {
		return this.descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishment() {
		return this.publishment;
	}

	public void setPublishment(String publishment) {
		this.publishment = publishment;
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

	public String getPublishdate() {
		return this.publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public Integer getTotalbook() {
		return totalbook;
	}

	public void setTotalbook(Integer totalbook) {
		this.totalbook = totalbook;
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

	

}