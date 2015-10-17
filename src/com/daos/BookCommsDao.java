package com.daos;

import java.util.List;

import com.dtos.BookComms;

public interface BookCommsDao extends BaseDao<BookComms>{
	
	public List<BookComms> BookCommsList(int id);

}
