package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
				SessionFactory factory = (SessionFactory) new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
					
				
				//create session 
				Session session = (Session) factory.getCurrentSession();
				
				try{
					//create 3 student object
					System.out.println("Creating 3 student object....");				
					Student tempStudent1 = new Student("John", "Doe", "John@luv2code.com");
					Student tempStudent2 = new Student("Mary", "Public", "Mary@luv2code.com");
					Student tempStudent3 = new Student("Bonita", "Applebum", "Bonita@luv2code.com");
					
					//start transaction
					session.beginTransaction();
					
					//save the object
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
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
