package com.hibernate.xmlBased;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class NumbersManager {
	   private static SessionFactory factory; 
	   public static void main(String[] args) {
	      try{
	         factory = new Configuration().configure().buildSessionFactory();
	         
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      
	      NumbersManager numberManager = new NumbersManager();
	      
	      //get the number and permute it 
	      LargestNum largeNumObj = new LargestNum();
	      System.out.println("Largest Number is: " + largeNumObj.getLargestNum(largeNumObj.permutationFinder(numberManager.getNumber())));	      
	      
	      /*
	      /* Add few employee records in database 
	      Integer empID1 = ME.addEmployee("Bill", "Wong", "Delivery Manager", 1000000);
	      Integer empID2 = ME.addEmployee("Craig", "Xoxo", "Manager", 500000);
	      Integer empID3 = ME.addEmployee("Jaykrushna", "Iyer", "Project Lead", 500000);

	      /* List down all the employees 
	      ME.listEmployees();

	      /* Print Total employee's count 
	      ME.countEmployee();

	      /* Print Total salary 
	      //ME.totalSalary();
	      */
	   }
	   
	   public String getNumber() {
		   Session session = factory.openSession();
		   Transaction tx = null;
		   String number="0";
		   try {
			   tx = session.beginTransaction();
			   
			   List numList = session.createQuery("from No").list();
			   No numberObj = new No();
			   numberObj = (No) numList.get(0);
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
	   
	   /* Method to CREATE an employee in the database 
	   public Integer addEmployee(String fname, String lname, String designation, int salary){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = new Employee(fname, lname, designation, salary);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	   }

	    Method to  READ all the employees having salary more than 500000 
	   public void listEmployees( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Criteria cr = session.createCriteria(Employee.class);
	         // Add restriction.
	         cr.add(Restrictions.gt("salary", 500000));
	         List employees = cr.list();
	         System.out.println("Employee list having salary > 500000"+employees);

	         for (Iterator iterator = 
	                           employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.print("  Last Name: " + employee.getDesignation());
	            System.out.println("  Salary: " + employee.getSalary()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	    Method to print total number of records 
	   public void countEmployee(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Criteria cr = session.createCriteria(Employee.class);

	         // To get total row count.
	         cr.setProjection(Projections.rowCount());
	         List rowCount = cr.list();

	         System.out.println("Total Count: " + rowCount.get(0) );
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   Method to print sum of salaries 
	   public void totalSalary(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Criteria cr = session.createCriteria(Employee.class);

	         // To get total salary.
	         cr.setProjection(Projections.sum("salary"));
	         List totalSalary = cr.list();

	         System.out.println("Total Salary: " + totalSalary.get(0) );
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   */
	}