package com.daos.impl.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.daos.ReservationDao;
import com.daos.impl.ReservationDaoImpl;
import com.dtos.Reservation;

public class ReservationDaoImplTest {
	private ReservationDao rdao = new ReservationDaoImpl();

//	@Test
//	public void testFindReservation() {
//		Reservation r = rdao.findReservation(1);
//		System.out.println(r.getUsers().getId());
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
	@Test
	public void testQueryAll() {
		List<Reservation>listr = rdao.queryAll("From Reservation");
		if(listr != null && listr.size() >0){
			for(int i = 0;i<listr.size();i++){
				System.out.println(listr.get(i).getState());
			}
			
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
