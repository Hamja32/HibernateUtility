package com.HibernateUtility.utilities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.HibernateUtility.entity.Customer;

public class HibernateUtils {
	private static SessionFactory factory;
	
	static {
		Configuration cfg = null;
		try {
			cfg = new Configuration();
			cfg.configure().addAnnotatedClass(Customer.class);
			factory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() {
		if(factory != null) {
			return factory.openSession();
		}else {
			return null;
		}
	}
	
	public static void closeSession(Session s) {
		if(s != null) {
			s.close();
		}
	}
	
	public static void closeSessionFactory() {
		if(factory != null) {
			factory.close();
		}
	}
	
	
}
