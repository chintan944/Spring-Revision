package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = (SessionFactory) new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = (Session) factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// option 2:HIbernate Query with HQl

			 // get the instructor from db
			int theId = 1;
			Query<Instructor> query = session
					.createQuery(
							"select i from Instructor i "
									+ "JOIN FETCH i.courses where i.id=:theInstructorId",
							Instructor.class);

			// set parameter
			query.setParameter("theInstructorId", theId);

			// execute the query and get instructor
			Instructor tempInstructor = query.getSingleResult();

			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			
			
			System.out.println("luv2code: courses : " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("luv2code: Done!");
		} finally {
			// add clean up code
			session.close();

			factory.close();
		}
	}

}