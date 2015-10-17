package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.daos.BookCommsDao;
import com.daos.BookDao;
import com.daos.impl.BookCommsDaoImpl;
import com.daos.impl.BookDaoImpl;
import com.dtos.Book;
import com.dtos.BookComms;
import com.dtos.Users;

public class BookCommsAction {
	private BookComms bookComms;
	private int bid;
	private int commid;
	
	private BookCommsDao bookcommDao = new BookCommsDaoImpl();
	private BookDao bDao = new BookDaoImpl();
	
	public BookComms getBookComms() {
		return bookComms;
	}
	public void setBookComms(BookComms bookComms) {
		this.bookComms = bookComms;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
	public int getCommid() {
		return commid;
	}
	public void setCommid(int commid) {
		this.commid = commid;
	}
	public String addBookComms(){
		Book book = bDao.queryOne("Book", bid);
		//System.out.println(book.getName());
		ServletActionContext.getRequest().getSession().setAttribute("bcomm", book);
		Users user = (Users)ServletActionContext.getRequest().getSession().getAttribute("user");
		Date now = new Date(); 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  	    String time1 = dateFormat.format( now ); 
  	    
		BookComms bc = new BookComms();
		bc.setBook(book);
		bc.setUsers(user);
		bc.setCommdate(time1);
		bc.setCommcontents(bookComms.getCommcontents());
		System.out.println("Contents:"+bookComms.getCommcontents());
		bookcommDao.add(bc);
		return "addcomms";
		
	}
	
	public String addBookCommReply(){
		BookComms orgbookcomms = bookcommDao.queryOne("BookComms", commid);
		
		BookComms repbookcomms = new BookComms();
		
		Book repbook = orgbookcomms.getBook();
		Users repuser = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		Date now = new Date(); 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  	    String time1 = dateFormat.format( now ); 
  	    
  	    repbookcomms.setCommdate(time1);
  	    repbookcomms.setUsers(repuser);
  	    repbookcomms.setBook(repbook);
  	    String concomms = bookComms.getCommcontents();
  	    repbookcomms.setCommcontents("<blockquote><footer>"+orgbookcomms.getUsers().getName()+" said at "+ orgbookcomms.getCommdate()+
				" :"+"</footer>"+ orgbookcomms.getCommcontents()+"</blockquote>"+concomms);
  	    
		repbookcomms.setBookComms(orgbookcomms);
		bookcommDao.add(repbookcomms);
		return "addcommsrep";
		
		
	}
	
	public String viewBookDetail2(){
		Book bookdetail1 = (Book) ServletActionContext.getRequest().getSession().getAttribute("bookdetail");
		List<BookComms> listbc = bookcommDao.BookCommsList(bookdetail1.getId());
		ServletActionContext.getRequest().getSession().setAttribute("count", listbc.size());
		ServletActionContext.getRequest().getSession().setAttribute("comm", listbc);
			if(bookdetail1.getTotalbook() != 0){
				ServletActionContext.getRequest().getSession().setAttribute("state","Unavailable");
			}
			ServletActionContext.getRequest().getSession().setAttribute("state","Available");
			return "addcommsjump";
		
	}
		

	public String viewBookDetail1(){
		Book bookdetail1 = (Book) ServletActionContext.getRequest().getSession().getAttribute("bcomm");
		ServletActionContext.getRequest().getSession().setAttribute("bookdetail", bookdetail1);
		List<BookComms> listbc = bookcommDao.BookCommsList(bookdetail1.getId());
		ServletActionContext.getRequest().getSession().setAttribute("count", listbc.size());
		ServletActionContext.getRequest().getSession().setAttribute("comm", listbc);
			if(bookdetail1.getTotalbook() != 0){
				ServletActionContext.getRequest().getSession().setAttribute("state","Unavailable");
			}
			ServletActionContext.getRequest().getSession().setAttribute("state","Available");
			return "addcommsjump";
		
	}
}
