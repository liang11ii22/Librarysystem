package com.daos.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.daos.CategoryDao;
import com.daos.impl.CategoryDaoImpl;
import com.dtos.Category;

public class CategoryDaoImplTest {
	private CategoryDao cdao = new CategoryDaoImpl();
//
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

	@Test
	public void testQueryName() {
		Category c = cdao.queryName("Category", "abc");
		System.out.println(c.getName());
	}

}
