package com.daos.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.daos.BookDao;
import com.daos.CategoryDao;
import com.daos.LibraryDao;
import com.daos.impl.BookDaoImpl;
import com.daos.impl.CategoryDaoImpl;
import com.daos.impl.LibraryDaoImpl;
import com.dtos.Book;

public class BookDaoImplTest {
	BookDao bdao = new BookDaoImpl(); 
	CategoryDao cdao = new CategoryDaoImpl();
	LibraryDao ldao = new LibraryDaoImpl();

//	@Test
//	public void testAdd() {
//		Book b = new Book();
//		b.setName("12");
//		b.setAuthor("12");
//		b.setBrief("12");
//		b.setCategory(cdao.queryName("Category", "1"));
//		//b.setLibrary(ldao.queryName("Library", "The SciTech Library"));
//		bdao.add(b);
//	}

//	@Test
//	public void testDel() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testQueryAll() {
		List<Book> booklistA = bdao.queryAll("select u from Book u where u.name like 'A%'");
		for(int i = 0;i<booklistA.size();i++){
			System.out.println(booklistA.get(i).getSchoollib().getName()+"   "+booklistA.get(i).getName());
		}
	}
//
//	@Test
//	public void testQueryOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearch() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testQueryName() {
//		fail("Not yet implemented");
//	}

}
