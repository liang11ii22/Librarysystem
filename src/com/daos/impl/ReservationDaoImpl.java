package com.daos.impl;

import java.util.List;

import com.daos.ReservationDao;
import com.dtos.Reservation;

public class ReservationDaoImpl extends BaseDaoImpl<Reservation> implements ReservationDao{
	/**
	 * check reservation whether exists
	 */
	@Override
	public Reservation findReservation(int uid) {
		String hql = "select a from com.dtos.Reservation a where a.users.id='"+uid+"'";
		List<Reservation>list = this.queryAll(hql);
		
	    return list.get(0);
	}
	
	/**
	 * check available seats
	 */
	@Override
	public Reservation queryReservation(String period, String time) {
		String hql = "select a from com.dtos.Reservation a where a.period='"+period+"' and a.time="
				+ "'"+time+"' and state = 'available'";
		List<Reservation>list = this.queryAll(hql);
		
	    return list.get(0);
	}

}
