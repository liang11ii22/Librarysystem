package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateHelp {
	
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);	
		return sessionFactory;
	}
	
	public static Session getSession() {
		sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		return session;
	}

}
