package com.daos.impl;

import java.util.List;

import com.daos.UserDao;
import com.dtos.Users;

public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao{

	@Override
	public Users loginUser(Users user) {
		
		String hql = "select a from com.dtos.Users a where a.name='"+user.getName()+"' and a.password='" +user.getPassword()+ "'";
		List<Users>list = this.queryAll(hql);
		if(list != null && list.size()>0){
			
			 return list.get(0);
		}else
			return null;
		
	}

	@Override
	public List<Users> listUsers(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

}
