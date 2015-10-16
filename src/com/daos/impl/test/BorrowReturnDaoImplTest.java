package com.daos.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.daos.BorrowReturnDao;
import com.daos.impl.BorrowReturnDaoImpl;
import com.dtos.BorrowReturn;

public class BorrowReturnDaoImplTest {
	private BorrowReturnDao brdao = new BorrowReturnDaoImpl();

	@Test
	public void testListBorrowBook() {
		List<BorrowReturn> brList = brdao.ListBorrowBook(1);
		System.out.println(brList.get(0).getBook().getName());
	}

//	@Test
//	public void testAdd() {
//		fail("Not yet implemented");
//	}
//
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
//	@Test
//	public void testQueryAll() {
//		fail("Not yet implemented");
//	}
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
