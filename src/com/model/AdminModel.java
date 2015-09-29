package com.model;

import com.dtos.Admin;

public interface AdminModel extends BaseModel<Admin>{
	
	public Admin login(Admin admin);

}
