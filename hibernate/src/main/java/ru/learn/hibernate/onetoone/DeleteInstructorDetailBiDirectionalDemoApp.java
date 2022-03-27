package ru.learn.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Instructor;
import ru.learn.hibernate.model.InstructorDetail;

public class DeleteInstructorDetailBiDirectionalDemoApp {

    private final static String HIBERNATE_CFG = "hibernate.cfg.xml";

    private final static SessionFactory sessionFactory = new Configuration()
            .configure(HIBERNATE_CFG)
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

    private static Session session;

    public static void main(String[] args) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            var instructorDetail = session.get(InstructorDetail.class, 1L);
            System.out.println("instructorDetail: " + instructorDetail.toString());
            System.out.println("Deleting...");
            session.delete(instructorDetail);
            System.out.println("Done...");
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
