package com.luv2code.hibernate.demo;

import java.nio.channels.SeekableByteChannel;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;

import com.luv2code.hibernate.demo.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
			
		
		//create session 
		Session session = (Session) factory.getCurrentSession();
		
		try{
		
			//start transaction
			session.beginTransaction();
			
			//query students
			java.util.List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			
			//query students: lastNam e= 'Doe'
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			
			//display the students
			System.out.println("\n\nstudents who have last name of Doe ");
			displayStudents(theStudents);
			
			//query students: lastName= 'Doe' OR firstName='Daffy'
			
			theStudents=session.createQuery("from Student s where"
											+" s.lastName = 'Doe' OR s.firstName = 'Daffy' ").getResultList();
			
			//display the students
			System.out.println("\n\nstudents who have last name of Doe OR s.firstName Daffy");
			displayStudents(theStudents);
			
			// query students where email LIKE '%luv2code.com'
			theStudents =session.createQuery("from Student s where s.email LIKE '%luv2code.com' ").getResultList();
			
			//display the students
			System.out.println("\n\nstudents who email ends with luv2code.com ");
			displayStudents(theStudents);
			
			
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally{
			factory.close();
		}
	}

	private static void displayStudents(java.util.List<Student> theStudents) {
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

}
