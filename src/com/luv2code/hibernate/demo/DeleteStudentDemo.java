package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int Id = 6;
			session.beginTransaction();
			Student stu = session.get(Student.class, Id);
			session.delete(stu);
			session.getTransaction().commit();
			
			session  = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student WHERE id=3").executeUpdate();
			session.getTransaction().commit();
			
		 } finally {
			session.close();
		  }
		}
}
