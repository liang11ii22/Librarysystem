package com.daos.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daos.DepartmentDao;
import com.dtos.Depart;
import com.util.HibernateHelp;

public class DepartmentDaoImpl extends BaseDaoImpl<Depart> implements DepartmentDao{

	@Override
	public Depart queryName(String name) {
		Depart d = new Depart();
		Session session = null;
		Transaction ts = null;
		List<Depart>list = null;
			try{
				session = HibernateHelp.getSession();
				ts = session.beginTransaction();
				Query query = session.createQuery("select d from Depart d where d.name='"+name+"'");
				d = (Depart)query.uniqueResult();
				ts.commit();
			}catch(Exception e){
				ts.rollback();
			}finally{
				session.close();
			}
		return d;
	}

}
