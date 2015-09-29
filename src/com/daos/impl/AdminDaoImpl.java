package com.daos.impl;

import java.util.List;

import com.daos.AdminDao;
import com.dtos.Admin;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

	@Override
	public Admin login(Admin admin) {
		Admin a = new Admin();
		String hql = "select a from com.dtos.Admin a where a.name='"+admin.getName()+"' and a.password='" +admin.getPassword()+ "'";
		List<Admin>list = this.queryAll(hql);
		if(list != null && list.size()>0){
			 a = list.get(0);
			 return a;
		}else
			return null;
		
	}

}
