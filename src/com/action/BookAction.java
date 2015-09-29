package com.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.daos.BookDao;
import com.daos.CategoryDao;
import com.daos.LibraryDao;
import com.daos.impl.BookDaoImpl;
import com.daos.impl.CategoryDaoImpl;
import com.daos.impl.LibraryDaoImpl;
import com.dtos.Book;
import com.dtos.Category;
import com.dtos.SchoolLib;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	private Book book;
	private BookDao bdao = new BookDaoImpl();
	private CategoryDao cdao = new CategoryDaoImpl();
	private LibraryDao ldao = new LibraryDaoImpl();
	private File myfile;
	private String myfileContentType;
	private String myfileFileName;
	private String realPath; 
	private String savepath;
	private int bid;
	private String characters;
	
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
		SchoolLib l = ldao.queryName("SchoolLib", book.getSchoollib().getName());
		b.setName(book.getName());
		System.out.println("Book"+book.getName());
		b.setAuthor(book.getAuthor());
		b.setBrief(book.getBrief());
		b.setCategory(c);
		b.setSchoollib(l);
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
		bdao.add(b);
		return "booklist";
		
		
	}
	
	public String showBookList(){
		List<String>slist = new ArrayList<String>();
		for(int i = 65; i<91; i++){
			slist.add(String.valueOf((char)i));
		}
		ServletActionContext.getRequest().getSession().setAttribute("slist", slist);
		List<Book> booklistA = bdao.queryAll("select u from Book u where u.name like 'A%'");
		List<Book> booklistB = bdao.queryAll("select u from Book u where u.name like 'B%'");
		List<Book> booklistC = bdao.queryAll("select u from Book u where u.name like 'C%'");
		List<Book> booklistD = bdao.queryAll("select u from Book u where u.name like 'D%'");
		List<Book> booklistE = bdao.queryAll("select u from Book u where u.name like 'E%'");
		List<Book> booklistF = bdao.queryAll("select u from Book u where u.name like 'F%'");
		List<Book> booklistG = bdao.queryAll("select u from Book u where u.name like 'G%'");
		List<Book> booklistH = bdao.queryAll("select u from Book u where u.name like 'H%'");
		List<Book> booklistI = bdao.queryAll("select u from Book u where u.name like 'I%'");
		List<Book> booklistJ = bdao.queryAll("select u from Book u where u.name like 'J%'");
		List<Book> booklistK = bdao.queryAll("select u from Book u where u.name like 'K%'");
		ServletActionContext.getRequest().getSession().setAttribute("booklistA", booklistA);
		ServletActionContext.getRequest().getSession().setAttribute("booklistB", booklistB);
		ServletActionContext.getRequest().getSession().setAttribute("booklistC", booklistC);
		ServletActionContext.getRequest().getSession().setAttribute("booklistD", booklistD);
		ServletActionContext.getRequest().getSession().setAttribute("booklistE", booklistE);
		ServletActionContext.getRequest().getSession().setAttribute("booklistF", booklistF);
		ServletActionContext.getRequest().getSession().setAttribute("booklistG", booklistG);
		ServletActionContext.getRequest().getSession().setAttribute("booklistH", booklistH);
		ServletActionContext.getRequest().getSession().setAttribute("booklistI", booklistI);
		ServletActionContext.getRequest().getSession().setAttribute("booklistJ", booklistJ);
		ServletActionContext.getRequest().getSession().setAttribute("booklistK", booklistK);
		return "showbooklist";
	}
	
	public String viewBookDetail(){
		Book bookdetail = bdao.queryOne("Book", bid);
		ServletActionContext.getRequest().getSession().setAttribute("bookdetail", bookdetail);
		return "bookdetails";
		
	}
	
	public String searchByChar(){
		List<Book>listbooks = bdao.queryAll("select u from Book u where u.name like '"+characters+"%'");
		ServletActionContext.getRequest().getSession().setAttribute("listbooks", listbooks);
		ServletActionContext.getRequest().getSession().setAttribute("chatacter", characters);
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
		SchoolLib l = ldao.queryName("SchoolLib", book.getSchoollib().getName());
		b.setId(b1.getId());
		b.setName(book.getName());
		System.out.println("Book"+book.getName());
		b.setAuthor(book.getAuthor());
		b.setBrief(book.getBrief());
		b.setCategory(c);
		b.setSchoollib(l);
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
