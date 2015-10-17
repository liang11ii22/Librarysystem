package com.dtos;

import java.math.BigDecimal;


/**
 * BorrowReturn entity. @author MyEclipse Persistence Tools
 */

public class BorrowReturn   {


    // Fields    

     private int id;
     private Book book;
     private Users users;
     private String BDate;
     private String BShouldDate;
     private String brdescp;
     private String RDate;


    // Constructors

    /** default constructor */
    public BorrowReturn() {
    }

    
    /** full constructor */
    public BorrowReturn(Book book, Users users, String BDate, String BShouldDate, String brdescp, String RDate) {
        this.book = book;
        this.users = users;
        this.BDate = BDate;
        this.BShouldDate = BShouldDate;
        this.brdescp = brdescp;
        this.RDate = RDate;
    }

   
    // Property accessors


    public Book getBook() {
        return this.book;
    }
    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setBook(Book book) {
        this.book = book;
    }

    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }

    public String getBDate() {
        return this.BDate;
    }
    
    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    public String getBShouldDate() {
        return this.BShouldDate;
    }
    
    public void setBShouldDate(String BShouldDate) {
        this.BShouldDate = BShouldDate;
    }

    public String getBrdescp() {
        return this.brdescp;
    }
    
    public void setBrdescp(String brdescp) {
        this.brdescp = brdescp;
    }

    public String getRDate() {
        return this.RDate;
    }
    
    public void setRDate(String RDate) {
        this.RDate = RDate;
    }
   








}