package com.dtos;

import java.math.BigDecimal;

/**
 * Reservation entity. @author MyEclipse Persistence Tools
 */

public class Reservation{

	// Fields

	private Integer id;
	private Integer seat;
	private Integer sid;
	private Integer status;
	private Integer library;

	// Constructors

	/** full constructor */
	public Reservation(int seat, Integer sid, int status,
			int library) {
		this.seat = seat;
		this.sid = sid;
		this.status = status;
		this.library = library;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSeat() {
		return this.seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public long getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getLibrary() {
		return this.library;
	}

	public void setLibrary(int library) {
		this.library = library;
	}

}