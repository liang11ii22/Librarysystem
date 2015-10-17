package com.daos;

import com.dtos.Reservation;

public interface ReservationDao extends BaseDao<Reservation>{
	public Reservation findReservation (int uid);
	public Reservation queryReservation(String period, String time);
}
