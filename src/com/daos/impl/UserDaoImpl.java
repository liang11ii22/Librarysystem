package com.daos.impl;

import java.util.List;

import com.daos.UserDao;
import com.dtos.Users;

public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao{

	@Override
	public Users loginUser(Users user) {
		Users u = null;
		String hql =  "from Users where name='"
				+ user.getName() + "' and password='" + user.getPassword() + "'";
		List<Users>list = this.queryAll(hql);
		if(list != null && list.size()>0){
			u = list.get(0);
		}
		return u;
	}

	@Override
	public List<Users> listUsers(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

}
