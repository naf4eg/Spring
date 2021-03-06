package ru.learn.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Course;
import ru.learn.hibernate.model.Instructor;
import ru.learn.hibernate.model.InstructorDetail;

public class GetCoursesDemoApp {

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
            var instructor1 = session.get(Instructor.class, 8L);
            var instructor2 = session.get(Instructor.class, 9L);
            session.createQuery("from Instructor where id = 8L or id = 9L")
                    .getResultList()
                    .forEach(System.out::println);
            System.out.println("Instructor: " + instructor1);

            //demonstration on debug mode how working LAZY fetch
            //see requests
            System.out.println("Courses instructor1: " + instructor1.getCourses());
            System.out.println("Courses instructor2: " + instructor2.getCourses());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
