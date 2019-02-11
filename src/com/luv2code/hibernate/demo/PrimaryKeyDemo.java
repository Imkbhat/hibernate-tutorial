package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
		
			Student stu1 = new Student("Alia", "Bhat", "kbs71190@gmail.com");
			Student stu2 = new Student("Amruta", "Bhat", "kbs71190@gmail.com");
			Student stu3 = new Student("Vidya", "Bhat", "kbs71190@gmail.com");
			
			session.beginTransaction();
			
			int theId1 = (Integer)session.save(stu1);
			int theId2 = (Integer)session.save(stu2);
			int theId3 = (Integer)session.save(stu3);
			
			session.getTransaction().commit();
			
			} finally {
				session.close();
			}
		}
}
