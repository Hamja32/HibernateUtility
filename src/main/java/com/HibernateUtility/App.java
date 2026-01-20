package com.HibernateUtility;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateUtility.entity.Customer;
import com.HibernateUtility.utilities.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Customer ram = new Customer();
    	ram.setCustomer_name("Ravi Kumar");
    	ram.setGender("Male");
    	ram.setMobile_number("5555555");
    	
    	Session session = HibernateUtils.getSession();
    	Transaction tx = session.beginTransaction();
    	
    	try {
    		session.persist(ram);
    		tx.commit();
    		System.out.println("Data inserted into db..");
    		
    	}catch (Exception e) {
    		tx.rollback();
			e.printStackTrace();
			System.out.println("Insertion operation failed");
		}finally {
			HibernateUtils.closeSession(session);
			HibernateUtils.closeSessionFactory();
		}
    	
    }
}
