package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.daos.BookDao;
import com.daos.BorrowReturnDao;
import com.daos.UserDao;
import com.daos.impl.BookDaoImpl;
import com.daos.impl.BorrowReturnDaoImpl;
import com.daos.impl.UserDaoImpl;
import com.dtos.Book;
import com.dtos.BorrowReturn;
import com.dtos.Users;

public class BorrowReturnAction {

	private UserDao udao = new UserDaoImpl();
	private BookDao bdao = new BookDaoImpl();
	private BorrowReturnDao borrowreturndao = new BorrowReturnDaoImpl();
	private int borrid;
	private int bid;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getBorrid() {
		return borrid;
	}

	public void setBorrid(int borrid) {
		this.borrid = borrid;
	}

	public String borrowBook() {
		Book book = bdao.queryOne("Book", borrid);
		Users u = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		BorrowReturn br = new BorrowReturn();

		if (u.getBookid() != null) {

			String str[] = u.getBookid().split(",");
			int n[] = new int[str.length];
			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < n.length; i++) {
				n[i] = Integer.parseInt(str[i]);
			}
			System.out.println("dfdfdfdf" + n.length);
			if (book.getTotalbook() <= 0 || n.length >= 7) {
				ServletActionContext.getRequest().setAttribute("msg",
						"Sorry, You can not borrow the book");
				return "borrowfail";
			} else {
				Date now = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd");
				String time1 = dateFormat.format(now);
				br.setBDate(time1);
				br.setBook(book);
				br.setUsers(u);

				Calendar c = Calendar.getInstance();
				c.add(Calendar.DAY_OF_MONTH, 60);
				br.setBShouldDate(dateFormat.format(c.getTime()));
				borrowreturndao.add(br);

				Book b1 = new Book();
				Users u1 = new Users();
				book.setTotalbook(book.getTotalbook() - 1);
				bdao.update(book);
				list.add(borrid);
				String borrowid = u.getBookid() + "," + list.get(0).toString();
				u.setBookid(borrowid);
				u.setDescription(borrowid);

				udao.update(u);
				ServletActionContext.getRequest().setAttribute("msg",
						"Borrow book success!");
				return "borrowsuccess";
			}
		} else {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String time1 = dateFormat.format(now);
			br.setBDate(time1);
			br.setBook(book);
			br.setUsers(u);

			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, 60);
			br.setBShouldDate(dateFormat.format(c.getTime()));
			borrowreturndao.add(br);

			book.setTotalbook(book.getTotalbook() - 1);
			bdao.update(book);
			String borrowid = String.valueOf(borrid);
			u.setBookid(borrowid);
			u.setDescription(borrowid);
			udao.update(u);
			ServletActionContext.getRequest().setAttribute("msg",
					"Borrow book success!");
			return "borrowsuccess";
		}

	}

	public String checkBorrowList() {
		Users u = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		String borrowBook = u.getBookid();
		String allBorrowBook = u.getDescription();
		
		
		if (borrowBook != null && allBorrowBook != null) {
			List<BorrowReturn>brList = borrowreturndao.ListBorrowBook(u.getId());

			
//			String str[] = borrowBook.split(",");
//			int n[] = new int[str.length];
//			List<Book> listBorrow = new ArrayList<Book>();
//			for (int i = 0; i < n.length; i++) {
//				n[i] = Integer.parseInt(str[i]);
//				Book bb = bdao.queryOne("Book", n[i]);
//				System.out.println(bb.getName());
//				listBorrow.add(bb);
//			}
//			System.out.println(listBorrow.size());

			String str1[] = allBorrowBook.split(",");
			int n1[] = new int[str1.length];
			List<Book> allListBorrow = new ArrayList<Book>();
			for (int i = 0; i < n1.length; i++) {
				n1[i] = Integer.parseInt(str1[i]);
				Book b1 = bdao.queryOne("Book", n1[i]);
				allListBorrow.add(b1);
			}
			ServletActionContext.getRequest().setAttribute("alllistborrow",
					allListBorrow);
			ServletActionContext.getRequest().setAttribute("listborrow",
					brList);
			return "borrowlist";
		} else if (borrowBook == null && allBorrowBook != null) {
			String str1[] = allBorrowBook.split(",");
			int n1[] = new int[str1.length];
			List<Book> allListBorrow = new ArrayList<Book>();
			for (int i = 0; i < n1.length; i++) {
				n1[i] = Integer.parseInt(str1[i]);
				Book b1 = bdao.queryOne("Book", n1[i]);
				allListBorrow.add(b1);
			}
			String alertRegister = "borrowlist";
			ServletActionContext.getRequest().setAttribute("alertRegister",
					alertRegister);

			ServletActionContext.getRequest().setAttribute("alllistborrow",
					allListBorrow);
			return "borrowlist";
		} else if (borrowBook == null && allBorrowBook == null) {
			String alertRegister = "borrowlist";
			ServletActionContext.getRequest().setAttribute("alertRegister",
					alertRegister);
			String alertRegister1 = "allborrowlist";
			ServletActionContext.getRequest().setAttribute("alertRegister1",
					alertRegister1);
			return "borrowlist";
		}
		return "borrowlist";

	}

	public String returnBooks() {
		Users u = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		String borrowBook = u.getBookid();
		BorrowReturn br = borrowreturndao.queryOne("BorrowReturn", bid);
		borrowreturndao.del(br);
		Book b = bdao.queryOne("Book", br.getBook().getId());
		b.setTotalbook(b.getTotalbook()+1);
		bdao.update(b);
		String alertRegister2 = "returnnotify";
		ServletActionContext.getRequest().setAttribute("alertRegister2",
				alertRegister2);
		
		return "returnbook";
	}

}
