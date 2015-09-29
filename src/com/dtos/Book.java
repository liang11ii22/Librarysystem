package com.dtos;



/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book{

	// Fields

	private Integer id;
	private Category category;
	private SchoolLib schoollib;
	private String name;
	private String brief;
	private String descp;
	private String author;
	private String publishment;
	private String attachment;
	private String publishdate;
	//private Set returnBorrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(Category category, SchoolLib schoollib, String name, String descp,
			String author, String publishment, String attachment, String brief, String publishdate) {
		this.category = category;
		this.schoollib = schoollib;
		this.name = name;
		this.descp = descp;
		this.author = author;
		this.publishment = publishment;
		this.attachment = attachment;
		this.brief = brief;
		this.publishdate = publishdate;
		//this.returnBorrows = returnBorrows;
	}

	// Property accessors

	

	public Category getCategory() {
		return this.category;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public SchoolLib getSchoollib() {
		return schoollib;
	}

	public void setSchoollib(SchoolLib schoollib) {
		this.schoollib = schoollib;
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
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

//	public Set getReturnBorrows() {
//		return this.returnBorrows;
//	}
//
//	public void setReturnBorrows(Set returnBorrows) {
//		this.returnBorrows = returnBorrows;
//	}

}