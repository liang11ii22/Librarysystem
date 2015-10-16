package com.daos;

import java.util.List;

import com.dtos.BorrowReturn;

public interface BorrowReturnDao extends BaseDao<BorrowReturn>{
	public List<BorrowReturn> ListBorrowBook(int id);
	

}
