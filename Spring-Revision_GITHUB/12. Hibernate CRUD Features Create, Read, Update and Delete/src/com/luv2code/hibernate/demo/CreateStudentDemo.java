package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
			
		
		//create session 
		Session session = (Session) factory.getCurrentSession();
		
		try{
			//create student object
			System.out.println("Creating new student object....");				
			Student tempStudent = new Student("Paul", "Wall", "Paul@luv2code.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the object
			session.save(tempStudent);
			System.out.println("Saving the student...");
			 
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally{
			factory.close();
		}
	}

}
