package ru.learn.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.*;

public class CreateCourseDemoApp {

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
            var course1 = new Course("Arduino learning");
            var course2 = new Course("STM32 developer");

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            var student = session.get(Student.class, 25L);
            System.out.println("Student: " + student);
            course1.addStudent(student);
            course2.addStudent(student);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
