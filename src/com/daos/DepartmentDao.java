package com.daos;

import com.dtos.Depart;

public interface DepartmentDao extends BaseDao<Depart>{
	public Depart queryName(String name);

}
