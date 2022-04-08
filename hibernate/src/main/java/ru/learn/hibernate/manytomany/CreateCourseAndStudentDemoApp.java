package ru.learn.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.*;

public class CreateCourseAndStudentDemoApp {

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
            var course1 = new Course("Ruby developer");
            var course2 = new Course("JS developer");

            var student1 = new Student("Melnichenko", "Alex", "KAl@yaya.eu");
            var student2 = new Student("Vyalbee", "Vyacheslav", "Buriev@googgal.eu");

            student1.addCourse(course2);
            student2.addCourse(course1);

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(student1);
            session.save(student2);
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
