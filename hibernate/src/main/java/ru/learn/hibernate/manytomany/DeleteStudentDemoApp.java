package ru.learn.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.*;

public class DeleteStudentDemoApp {

    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

    private static final SessionFactory sessionFactory = new Configuration()
            .configure(HIBERNATE_CFG)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Review.class)
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    private static Session session;

    public static void main(String[] args) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            var student  = session.get(Student.class, 26L);
            System.out.println("Student: " + student);
            System.out.println("Courses: " + student.getCourses());
            session.delete(student);
            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
