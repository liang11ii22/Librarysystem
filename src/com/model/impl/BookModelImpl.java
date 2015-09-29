package com.model.impl;

import com.daos.BookDao;
import com.daos.impl.BookDaoImpl;
import com.dtos.Book;
import com.model.BookModel;

public class BookModelImpl extends BaseModelImpl<Book> implements BookModel{
	private BookDao bookDao = new BookDaoImpl();

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
}
