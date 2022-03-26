package ru.learn.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Instructor;
import ru.learn.hibernate.model.InstructorDetail;

public class DeleteInstructorDemoApp {

    private final static String HIBERNATE_CFG = "hibernate.cfg.xml";

    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure(HIBERNATE_CFG)
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .buildSessionFactory();

            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            var instructor = session.get(Instructor.class, 2L);
            session.getTransaction().commit();
            System.out.println("instructor = " + instructor);

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(instructor);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("from Instructor");
            session.createQuery("from InstructorDetail ");
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
