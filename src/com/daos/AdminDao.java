package com.daos;

import com.dtos.Admin;

public interface AdminDao extends BaseDao<Admin> {
	public Admin login(Admin admin);

}
