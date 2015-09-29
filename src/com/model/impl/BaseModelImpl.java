package com.model.impl;

import java.util.List;

import com.daos.BaseDao;
import com.model.BaseModel;

public class BaseModelImpl<T> implements BaseModel<T>{
	
	private BaseDao<T> bdao;

	public BaseDao<T> getBdao() {
		return bdao;
	}

	public void setBdao(BaseDao<T> bdao) {
		this.bdao = bdao;
	}

	@Override
	public void add(T t) {
		bdao.add(t);
	}

	@Override
	public void del(T t) {
		bdao.del(t);
	}

	@Override
	public void update(T t) {
		bdao.update(t);
	}

	@Override
	public List<T> queryAll(String hql) {
		
		return bdao.queryAll(hql);
	}

	@Override
	public T queryOne(String hql, Integer id) {
		
		return bdao.queryOne(hql, id);
	}

	@Override
	public List<T> search(String table, String name) {
		
		return bdao.search(table, name);
	}

}
