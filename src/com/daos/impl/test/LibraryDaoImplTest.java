package com.daos.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.daos.LibraryDao;
import com.daos.impl.LibraryDaoImpl;

import com.dtos.SchoolLib;

public class LibraryDaoImplTest {
private LibraryDao ldao = new LibraryDaoImpl();

	public LibraryDao getLdao() {
	return ldao;
}

public void setLdao(LibraryDao ldao) {
	this.ldao = ldao;
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
//		List<Library>list = ldao.queryAll("from Library");
//		System.out.println(list.size());
//	}

//	@Test
//	public void testQueryOne() {
//		Librarys1 l = ldao.queryOne("Librarys1", 1);
//		System.out.println( l.getName());
//	}
//
//	@Test
//	public void testSearch() {
//		fail("Not yet implemented");
//	}
@Test
public void testQueryName() {
	SchoolLib l = ldao.queryName("SchoolLib", "sciTechnology");
	System.out.println(l.getName());
}

}
