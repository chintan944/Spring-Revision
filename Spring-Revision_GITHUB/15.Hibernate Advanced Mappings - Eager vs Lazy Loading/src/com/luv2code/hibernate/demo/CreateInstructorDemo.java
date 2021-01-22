package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = (Session) factory.getCurrentSession();

		try {
			// create the objects
			
			Instructor tempInstructor = new Instructor("Susan", "Public",
					"susan.pubic@lv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"htps://www.youtube.com", "Video Games");
			
			// associate objects

			tempInstructor.setInstructorDetailId(tempInstructorDetail);

			// start transaction
			session.beginTransaction();

			// save Instructor

			// Note: This will ALSO SAVE the details object
			// because of CASCADE.ALL
			//
			System.out.println("Saving instructor : " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
