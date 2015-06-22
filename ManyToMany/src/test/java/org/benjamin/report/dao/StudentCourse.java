package org.benjamin.report.dao;

import java.util.ArrayList;
import java.util.List;

import org.benjamin.hibernate.Course;
import org.benjamin.hibernate.Student;
import org.benjamin.report.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentCourse {
	
	
	public static void main(String[] args) {
		StudentCourse sd = new StudentCourse();
		HibernateUtils hu = new HibernateUtils();
		
		SessionFactory sf = hu.getSessionFactory();
		Session sesstion = hu.getSession();
	
		Student student = new Student();
		student.setName("Student_1");
	
		
		Student student2 = new Student();
		student2.setName("Student_2");
//		sesstion.save(student2);
		
		Student student3 = new Student();
		student3.setName("Student_3");
//		sesstion.save(student3);
		
		Course course = new Course();
		course.setName("Course");
//		sesstion.save(course);
		
		Course course2 = new Course();
		course2.setName("Course_2");
//		sesstion.save(course2);
		
		Course course3 = new Course();
		course3.setName("Course_3");
//		sesstion.save(course3);
		
		List<Course> courses = new ArrayList<Course>();
		courses.add(course);
		courses.add(course2);
		List<Course> courses2 = new ArrayList<Course>();
		courses2.add(course2);
		courses2.add(course3);
		
		List<Student> students = new ArrayList<Student>();
		students.add(student);
		students.add(student2);
		List<Student> students2 = new ArrayList<Student>();
		students2.add(student2);
		students2.add(student3);
		
		student.setCourses(courses);
		sesstion.save(student);
		student2.setCourses(courses2);
		sesstion.save(student2);
		student3.setCourses(courses);
		sesstion.save(student3);
		
		sesstion.save(course);
		sesstion.save(course2);
		sesstion.save(course3);
		
		sesstion.getTransaction().commit();
		
		sesstion.close();
		hu.closeSesstionFactory();
	}

}
