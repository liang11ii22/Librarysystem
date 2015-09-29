package com.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.* ;
import java.util.List;

import org.junit.Test;

import com.daos.AdminDao;
import com.daos.impl.AdminDaoImpl;
import com.dtos.Admin;

public class AdminDaoImplTest {
	private AdminDao adao = new AdminDaoImpl();

//	@Test
//	public void testLogin() {
//		Admin a = new Admin();
//		a.setName("aa");
//		a.setPassword("123");
//		Admin a1 = adao.login(a);
//		//assertThat(adao.login(a), notNullValue());
//		System.out.println(a1.getDescription());
//	}

	@Test
	public void testAdd() {
		Admin a = new Admin();
		a.setId(3);
		a.setName("cc");
		a.setPassword("123");
		a.setDescription("abc");
		adao.add(a);
	}

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
//		List<Admin>list = adao.queryAll("from Admin");
//		for(int i = 0;i<list.size();i++){
//			System.out.println(list.get(i).getName());
//		}
//		
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

}
