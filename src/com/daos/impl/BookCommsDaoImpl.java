package com.daos.impl;

import java.util.List;

import com.daos.BookCommsDao;
import com.dtos.BookComms;

public class BookCommsDaoImpl extends BaseDaoImpl<BookComms> implements BookCommsDao{

	@Override
	public List<BookComms> BookCommsList(int id) {
		String hql =  "select a from com.dtos.BookComms a where a.book.id="+id;
		List<BookComms> list = this.queryAll(hql);
		if(list.size()>0 && list != null){
			return list;
		}
		return null;
	}

}
