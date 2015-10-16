package com.daos.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.daos.UserDao;
import com.daos.impl.UserDaoImpl;
import com.dtos.Users;

public class UserDaoImplTest {
	private UserDao udao = new UserDaoImpl();

//	@Test
//	public void testLoginUser() {
//		Users u = new Users();
//		u.setName("a1");
//		u.setPassword("123");
//		Users u1 = udao.loginUser(u);
//		System.out.println(u1.getName());
//	}

//	@Test
//	public void testListUsers() {
//		udao.queryAll("")
//	}

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
	@Test
	public void testQueryOne() {
		Users u = udao.queryOne("Users", 1);
		String str[] = u.getBookid().split(",");
		int n[] = new int [str.length];
		//String bid = u.getBookid();
		
		System.out.println(n.length);
	}

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
