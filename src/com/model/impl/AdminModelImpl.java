package com.model.impl;

import com.daos.AdminDao;
import com.daos.impl.AdminDaoImpl;
import com.dtos.Admin;
import com.model.AdminModel;

public class AdminModelImpl extends BaseModelImpl<Admin> implements AdminModel{

	private AdminDao adao = new AdminDaoImpl();
	public AdminDao getAdao() {
		return adao;
	}
	public void setAdao(AdminDao adao) {
		this.adao = adao;
	}
	@Override
	public Admin login(Admin admin) {
		
		return adao.login(admin);
	}

}
