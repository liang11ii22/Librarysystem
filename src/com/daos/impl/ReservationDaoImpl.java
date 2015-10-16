package com.daos.impl;

import java.util.List;

import com.daos.ReversationDao;
import com.dtos.Reservation;

public class ReservationDaoImpl extends BaseDaoImpl<Reservation> implements ReversationDao{

	@Override
	public Reservation findReservation(int uid) {
		String hql = "select a from com.dtos.Reservation a where a.users.id='"+uid+"'";
		List<Reservation>list = this.queryAll(hql);
		
	    return list.get(0);
	}

}
