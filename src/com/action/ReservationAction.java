package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.daos.LibraryDao;
import com.daos.ReservationDao;
import com.daos.impl.LibraryDaoImpl;
import com.daos.impl.ReservationDaoImpl;
import com.dtos.Reservation;

public class ReservationAction {
	private ReservationDao rDao = new ReservationDaoImpl();
	private LibraryDao lDao = new LibraryDaoImpl();
	
	public String showAllSeats(){
		List<Reservation> seatsList = rDao.queryAll("from Reservation");
		
		System.out.println("RESERVATIONSIZE"+seatsList.size());
		ServletActionContext.getRequest().getSession().setAttribute("seatslist", seatsList);
		return "seatslist";
	}
	
}
