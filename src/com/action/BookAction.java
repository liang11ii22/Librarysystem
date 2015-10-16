package com.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.daos.BookCommsDao;
import com.daos.BookDao;
import com.daos.CategoryDao;
import com.daos.LibraryDao;
import com.daos.impl.BookCommsDaoImpl;
import com.daos.impl.BookDaoImpl;
import com.daos.impl.CategoryDaoImpl;
import com.daos.impl.LibraryDaoImpl;
import com.dtos.Book;
import com.dtos.BookComms;
import com.dtos.Category;
import com.dtos.SchoolLib;
import com.dtos.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.util.HibernatePage;

public class BookAction extends ActionSupport{
	private Book book;
	private BookDao bdao = new BookDaoImpl();
	private CategoryDao cdao = new CategoryDaoImpl();
	private LibraryDao ldao = new LibraryDaoImpl();
	private BookCommsDao bookcommDao = new BookCommsDaoImpl();
	private File myfile;
	private String myfileContentType;
	private String myfileFileName;
	private String realPath; 
	private String savepath;
	private int bid;
	private String characters;
	private int cpage;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookDao getBdao() {
		return bdao;
	}
	public void setBdao(BookDao bdao) {
		this.bdao = bdao;
	}
	public File getMyfile() {
		return myfile;
	}
	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}
	public String getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}
	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getCharacters() {
		return characters;
	}
	public void setCharacters(String characters) {
		this.characters = characters;
	}
	
	
	public int getCpage() {
		return cpage;
	}
	public void setCpage(int cpage) {
		this.cpage = cpage;
	}
	public String addBookJump(){
		List<Category> catelist = cdao.queryAll("from Category");
		List<SchoolLib> liblist = ldao.queryAll("from SchoolLib");
		
		ServletActionContext.getRequest().getSession().setAttribute("catelist", catelist);
		ServletActionContext.getRequest().getSession().setAttribute("liblist", liblist);
		return "addbookjump";

	}
	
	public String addBook(){
		
		
		Book b = new Book();
		realPath = ServletActionContext.getServletContext().getRealPath("/pics");
		System.out.println("sdfdfsdfdsfdsrealPath"+realPath);
		
		File file = new File(realPath);

		if (!file.exists()) {
			file.mkdir();
		}

		File newfile = new File(file, myfileFileName);

		
		Category c = cdao.queryName("Category", book.getCategory().getName());
		SchoolLib l = ldao.queryName("SchoolLib", book.getSchoolLib().getName());
		System.out.println(l.getName());
		b.setName(book.getName());
		System.out.println("Book"+book.getName());
		b.setAuthor(book.getAuthor());
		b.setBrief(book.getBrief());
		b.setCategory(c);
		b.setSchoolLib(l);
		b.setDescp(book.getDescp());
		b.setPublishment(book.getPublishment());
		b.setPublishdate(book.getPublishdate());
		b.setTotalbook(book.getTotalbook());
		try {
			FileUtils.copyFile(myfile, new File(file, myfileFileName));
			FileInputStream fin = new FileInputStream(newfile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = ServletActionContext.getRequest().getContextPath();
		b.setAttachment(ServletActionContext.getRequest().getScheme() + "://"
				+ ServletActionContext.getRequest().getServerName() + ":"
				+ ServletActionContext.getRequest().getServerPort() + path
				+ "/pics" + "/" + myfileFileName);
		bdao.add(b);
		return "booklist";
		
		
	}
	
	public String showBookList(){
		List<String> slist = new ArrayList<String>();
		for (int i = 65; i < 91; i++) {
			slist.add(String.valueOf((char) i));
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("slist", slist);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		if (cpage <= 0) {
			cpage = 1;
		}
		int curpage = cpage;// 当前页
		int pagesize = 2;// 每页显示数
	   
		
		List<Book> booklistA = HibernatePage.findOnePage(session,"select u from Book u order by name", curpage, pagesize);

    	ServletActionContext.getRequest().getSession().setAttribute("booklistA", booklistA);

		Users u = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(u !=null){
			return "showbooklist_front";
		}else{
			return "showbooklist";
		}
		
	}
	
	
	
	public String viewBookDetail(){
		Book bookdetail = bdao.queryOne("Book", bid);
		ServletActionContext.getRequest().getSession().setAttribute("bookdetail", bookdetail);
		List<BookComms> listbc = bookcommDao.BookCommsList(bid);
		ServletActionContext.getRequest().getSession().setAttribute("comm", listbc);
		ServletActionContext.getRequest().getSession().setAttribute("count", listbc.size());
		Users u = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(u !=null){
			if(bookdetail.getTotalbook() != 0){
				ServletActionContext.getRequest().getSession().setAttribute("state","Unavailable");
			}
			ServletActionContext.getRequest().getSession().setAttribute("state","Available");
			return "bookdetail_front";
		}
		return "bookdetails";
		
	}
	
	public String searchByChar(){
		List<Book>listbooks = bdao.queryAll("select u from Book u where u.name like '"+characters+"%'");
		ServletActionContext.getRequest().getSession().setAttribute("listbooks", listbooks);
		ServletActionContext.getRequest().getSession().setAttribute("chatacter", characters);
		Users u = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(u !=null){
			return "singlebooklist_front";
		}
		return "singbooklist";
	}
	
	public String updateBook(){
		Book bookdetail = bdao.queryOne("Book", bid);
		ServletActionContext.getRequest().getSession().setAttribute("bookdetail", bookdetail);
		
		List<Category> catelist = cdao.queryAll("from Category");
		List<SchoolLib> liblist = ldao.queryAll("from SchoolLib");
		
		ServletActionContext.getRequest().getSession().setAttribute("catelist", catelist);
		ServletActionContext.getRequest().getSession().setAttribute("liblist", liblist);
		return "uodatebookdetail";
	}
	
	public String updateBookDetails(){
		Book b = new Book();
		Book b1 = (Book)ServletActionContext.getRequest().getSession().getAttribute("bookdetail");
		realPath = ServletActionContext.getServletContext().getRealPath("/pics");
		System.out.println("sdfdfsdfdsfdsrealPath"+realPath);
		
		File file = new File(realPath);

		if (!file.exists()) {
			file.mkdir();
		}

		File newfile = new File(file, myfileFileName);

		
		Category c = cdao.queryName("Category", book.getCategory().getName());
		SchoolLib l = ldao.queryName("SchoolLib", book.getSchoolLib().getName());
		b.setId(b1.getId());
		b.setName(book.getName());
		System.out.println("Book"+book.getName());
		b.setAuthor(book.getAuthor());
		b.setBrief(book.getBrief());
		b.setCategory(c);
		b.setSchoolLib(l);
		b.setDescp(book.getDescp());
		b.setPublishment(book.getPublishment());
		b.setPublishdate(book.getPublishdate());
		try {
			FileUtils.copyFile(myfile, new File(file, myfileFileName));
			FileInputStream fin = new FileInputStream(newfile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = ServletActionContext.getRequest().getContextPath();
		b.setAttachment(ServletActionContext.getRequest().getScheme() + "://"
				+ ServletActionContext.getRequest().getServerName() + ":"
				+ ServletActionContext.getRequest().getServerPort() + path
				+ "/pics" + "/" + myfileFileName);
		bdao.update(b);
		ServletActionContext.getRequest().setAttribute("msg","Update info success!");
		return "booklist";
	}
	
	public String deleteBook(){
		Book bdel = bdao.queryOne("Book", bid);
		bdao.del(bdel);
		ServletActionContext.getRequest().setAttribute("msg","Delete success!");
		return "booklist";
	}

}
