package com.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class HibernatePage {
	
	 public static List findOnePage(Session session,String strHQL, int offset, int pagesize){
	        List lst = null;
	        try {
	            Query query = session.createQuery(strHQL);
	            if (offset != 0 && pagesize != 0) {
	                query.setFirstResult((offset - 1) * pagesize);
	                query.setMaxResults(pagesize);
	            }
	            lst = query.list();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return lst;
	    }

}
