package com.dtos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * SchoolLib entity. @author MyEclipse Persistence Tools
 */

public class SchoolLib  {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String brief;
	private String opentime;
	private String location;
	private String locatedescp;
	private String attachment;
	private Set books = new HashSet(0);
	private Set reservations = new HashSet(0);

	// Constructors

	/** default constructor */
	public SchoolLib() {
	}

	/** full constructor */
	public SchoolLib(String name, String description, String brief,
			String opentime, String location, String locatedescp,
			String attachment, Set books, Set reservations) {
		this.name = name;
		this.description = description;
		this.brief = brief;
		this.opentime = opentime;
		this.location = location;
		this.locatedescp = locatedescp;
		this.attachment = attachment;
		this.books = books;
		this.reservations = reservations;
	}

	// Property accessors

	

	public String getName() {
		return this.name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getOpentime() {
		return this.opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocatedescp() {
		return this.locatedescp;
	}

	public void setLocatedescp(String locatedescp) {
		this.locatedescp = locatedescp;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

	public Set getReservations() {
		return reservations;
	}

	public void setReservations(Set reservations) {
		this.reservations = reservations;
	}

}