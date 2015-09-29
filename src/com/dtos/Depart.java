package com.dtos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Depart entity. @author MyEclipse Persistence Tools
 */

public class Depart implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String name;
	private Set userses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Depart() {
	}

	/** full constructor */
	public Depart(String name, Set userses) {
		this.name = name;
		this.userses = userses;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}