package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.daos.ReversationDao;
import com.daos.UserDao;
import com.daos.impl.ReservationDaoImpl;
import com.daos.impl.UserDaoImpl;
import com.dtos.Reservation;
import com.dtos.Users;

public class ReservationAction {
	
	private ReversationDao rdao = new ReservationDaoImpl();
	private UserDao udao = new UserDaoImpl();
	private int seatid;
	
	
	
	public int getSeatid() {
		return seatid;
	}



	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}



	public String checkSeat(){
//		Users user = (Users)ServletActionContext.getRequest().getSession().getAttribute("user");
//		int flag = 0;
//		List<Reservation>listr = rdao.queryAll("From Reservation");
//		for(int i = 0;i<listr.size();i++){
//			if(listr.get(i).getUsers().getName().equals(user.getName())|| listr.get(i).getUsers().getName() == null){
//				flag = 1;
//				break;
//			}else if(listr.get(i).getUsers().getId() == null){
//				flag = 0;
//			}
//		}
		
		if(flag == 1){
			return"bookbefore";
		}else{
			return"jumptobook";
		}
		
		
	}

}
