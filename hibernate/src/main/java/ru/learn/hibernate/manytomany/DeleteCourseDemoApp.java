package ru.learn.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.*;

public class DeleteCourseDemoApp {

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
            var course  = session.get(Course.class, 34L);
            System.out.println("Course: " + course);
            session.delete(course);
            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
