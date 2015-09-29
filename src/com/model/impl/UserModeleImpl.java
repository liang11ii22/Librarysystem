package com.model.impl;

import com.daos.UserDao;
import com.daos.impl.UserDaoImpl;
import com.dtos.Users;
import com.model.UserModel;

public class UserModeleImpl extends BaseModelImpl<Users> implements UserModel{
	
	private UserDao udao = new UserDaoImpl();
	

	public UserDao getUdao() {
		return udao;
	}


	public void setUdao(UserDao udao) {
		this.udao = udao;
	}


	@Override
	public Users loginUser(Users user) {
		// TODO Auto-generated method stub
		return udao.loginUser(user);
	}

}
