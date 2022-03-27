package ru.learn.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Course;
import ru.learn.hibernate.model.Instructor;
import ru.learn.hibernate.model.InstructorDetail;

public class DeleteCoursesDemoApp {

    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

    private static final SessionFactory sessionFactory = new Configuration()
            .configure(HIBERNATE_CFG)
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    private static Session session;

    public static void main(String[] args) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            var course = session.get(Course.class, 2L);
            System.out.println("Course: " + course);
            session.delete(course);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
