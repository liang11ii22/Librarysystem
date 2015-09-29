package com.daos;

import java.util.List;

public interface BaseDao<T> {
	public void add(T t);
	public void del(T t);
	public void update(T t);
	public List<T> queryAll(String hql);
	public T queryOne(String hql,Integer id);
	public T queryName(String hql, String name);
	public List<T> search(String table,String name);

}
