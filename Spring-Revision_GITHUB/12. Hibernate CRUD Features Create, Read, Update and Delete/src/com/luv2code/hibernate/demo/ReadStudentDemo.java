package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "Daffy@luv2code.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the object
			session.save(tempStudent);
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			 
			//commit transaction
			session.getTransaction().commit();
			
			//MY NEW CODE
			
			//find out the student's id:Primary key
			System.out.println("Saved student.Generated id : "+tempStudent.getId());
			
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
				
			
			//retrieve the student based on the id:  primary key
			System.out.println("\nGetting stundent with id: "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class,tempStudent.getId());
			
			System.out.println("Get complete: "+myStudent);
			
			//commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally{
			factory.close();
		}
	}

}
