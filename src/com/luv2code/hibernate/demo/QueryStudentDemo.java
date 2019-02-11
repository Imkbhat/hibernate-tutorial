package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
				
			List<Student> studentList = session.createQuery("from Student").list();
			displayStudent(studentList);
			
			List<Student>  studentsList = session.createQuery("from Student s WHERE s.firstName ='Anusha'").list();
			displayStudent(studentsList);
			
			List<Student> studsList = session.createQuery("from Student s WHERE s.lastName='Bhat' and s.firstName='Pooja'").list();
			displayStudent(studsList);
			
			List<Student> stuList = session.createQuery("from Student s WHERE s.email LIKE '%71190%'").list();
			displayStudent(stuList);

			session.getTransaction().commit();
			
		 } finally {
			session.close();
		  }
		}

	private static void displayStudent(List<Student> studentList) {
		for (Student stu : studentList) {
			System.out.println(stu);
		}
	}
}
