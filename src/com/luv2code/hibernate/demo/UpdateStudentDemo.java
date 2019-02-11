package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int Id = 1;
			session.beginTransaction();
			Student stu = session.get(Student.class, Id);
			stu.setFirstName("Pratibha");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Update email
			
			session.createQuery("UPDATE Student set email = 'bar@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		 } finally {
			session.close();
		  }
		}
}
