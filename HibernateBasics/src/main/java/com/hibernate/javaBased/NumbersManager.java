package com.hibernate.javaBased;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class NumbersManager {
	private static SessionFactory concreteSessionFactory=null;
	static {
		try {
			Properties properties = new Properties();
			properties.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@tssr101:1521:init1");
			properties.setProperty("hibernate.connection.username", "PPDW_OWNER");
			properties.setProperty("hibernate.connection.password", "USR_ppd1");
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
			properties.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
			
			concreteSessionFactory = new AnnotationConfiguration().
						addPackage("com.hibernate.javaBased").
						addProperties(properties).
						addAnnotatedClass(No.class).
						buildSessionFactory();
						
		} catch(Throwable thex) {
			thex.fillInStackTrace();
		}
	}
	
	public static Session getSession() throws HibernateException {
		return concreteSessionFactory.openSession();
	}

	public static void main(String[] args) {
		
		NumbersManager nm = new NumbersManager();
		LargestNum largestNum = new LargestNum();
		System.out.println(largestNum.getLargestNum(largestNum.permutationFinder(nm.getNumber())));
		
	}
	
	public String getNumber() {
		Session session = getSession();
		Transaction tx = null;
		   String number="0";
		   try {
			   tx = session.beginTransaction();
			   No numberObj = (No)session.get(No.class, new Integer(1));
			   number = numberObj.getNum();
			   tx.commit();
		   } catch (HibernateException e) {
			   if(tx != null) tx.rollback();
			   e.printStackTrace();
		   } finally {
			   session.close();
		   }
		   return number;
	} 

}