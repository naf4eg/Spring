package ru.learn.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Instructor;
import ru.learn.hibernate.model.InstructorDetail;

/**
 * App for bi-derectional mode
 */
public class GetInstructorBiDirectionalDemoApp {

    private final static String HIBERNATE_CFG = "hibernate.cfg.xml";

    private final static SessionFactory sessionFactory = new Configuration()
            .configure(HIBERNATE_CFG)
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();
    private static Session session = sessionFactory.getCurrentSession();

    public static void main(String[] args) {
        try {
            session.beginTransaction();
            var instructorDetail = session.get(InstructorDetail.class, 1L);
            System.out.println("instructorDetail: " + instructorDetail.toString());
            var instructor = instructorDetail.getInstructor();
            System.out.println("instructor: " + instructor.toString());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //session.close if ids is not find
            //it is prevents leak pool
            session.close();
            sessionFactory.close();
        }
    }
}
