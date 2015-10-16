package com.daos.impl;

import java.util.List;

import com.daos.BorrowReturnDao;
import com.dtos.BorrowReturn;

public class BorrowReturnDaoImpl extends BaseDaoImpl<BorrowReturn> implements BorrowReturnDao{

	@Override
	public List<BorrowReturn> ListBorrowBook(int id) {

		String hql = "select a from com.dtos.BorrowReturn a where a.users.id='"+id+"'";
		List<BorrowReturn>list = this.queryAll(hql);
		
	    return list;
	}

}
