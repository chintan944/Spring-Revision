package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = (Session) factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId=2999;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("tempInstructorDetail : "+tempInstructorDetail );
			
			//print associate instructor 
			System.out.println("the associated instructor  : "+tempInstructorDetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			//handle the connection leak issue
			session.close();
			factory.close();
		}
	}

}