package com.daos.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daos.BaseDao;
import com.util.HibernateHelp;

public class BaseDaoImpl<T> implements BaseDao<T>{

	@Override
	public void add(T t){
		Session session = null;
		Transaction ts = null;
		try{
			session = HibernateHelp.getSession();
			ts = session.beginTransaction();
			session.save(t);
			ts.commit();
			
		}catch(Exception d){
			ts.rollback();
		}
	}

	@Override
	public void del(T t){
		Session session = null;
		Transaction ts = null;
		try{
			session = HibernateHelp.getSession();
			ts = session.beginTransaction();
			session.delete(t);
			ts.commit();
			
		}catch(Exception d){
			ts.rollback();
		}finally{
			session.close();
		}
	}
	@Override
	public void update(T t){
		Session session = null;
		Transaction ts = null;
		try{
			session = HibernateHelp.getSession();
			ts = session.beginTransaction();
			session.update(t);
			ts.commit();
			
		}catch(Exception d){
			ts.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<T> queryAll(String hql){
		Session session = null;
		Transaction ts = null;
		List<T>list = null;
		try{
			session = HibernateHelp.getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.list();
			ts.commit();
			
		}catch(Exception d){
			ts.rollback();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public T queryOne(String hql, Integer id) {
		Session session = null;

		Transaction ts = null;
		List<T> list = null;
		try {
			session = HibernateHelp.getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("select u from " + hql
					+ " u where u.id=" + id);
			list = query.list();
			ts.commit();
		} catch (Exception d) {
			ts.rollback();
		} finally {
			session.close();
		}
		return list.get(0);
	}


	@Override
	public List<T> search(String table, String name) {

		Session session = null;

		Transaction ts = null;
		List<T> list = null;
		try {
			session = HibernateHelp.getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("select u from " + table
					+ " u where u.name like '%" + name + "%'");
			list = query.list();
			ts.commit();
		} catch (Exception d) {
			ts.rollback();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public T queryName(String hql, String name) {
		Session session = null;

		Transaction ts = null;
		List<T> list = null;
		try {
			session = HibernateHelp.getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("select u from " + hql
					+ " u where u.name='" + name+"'");
			list = query.list();
			ts.commit();
		} catch (Exception d) {
			ts.rollback();
		} finally {
			session.close();
		}
		return list.get(0);
	}

}
