package com.model.impl;

import com.daos.ReservationDao;
import com.daos.impl.ReservationDaoImpl;
import com.dtos.Reservation;
import com.model.ReservationModel;



public class ReservationModelImpl extends BaseModelImpl<Reservation> implements ReservationModel{
	private ReservationDao rDao = new ReservationDaoImpl();

	public ReservationDao getBookDao() {
		return rDao;
	}

	public void setBookDao(ReservationDao rDao) {
		this.rDao = rDao;
	}
}
