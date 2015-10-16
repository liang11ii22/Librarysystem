package com.daos;

import com.dtos.Reservation;

public interface ReversationDao extends BaseDao<Reservation>{
	public Reservation findReservation (int uid);

}
