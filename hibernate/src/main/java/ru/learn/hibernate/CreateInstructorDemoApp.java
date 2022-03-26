package ru.learn.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Instructor;
import ru.learn.hibernate.model.InstructorDetail;

public class CreateInstructorDemoApp {

    private final static String HIBERNATE_CFG = "hibernate.cfg.xml";

    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure(HIBERNATE_CFG)
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .buildSessionFactory();

            var session = sessionFactory.getCurrentSession();

            var instructor1 = new Instructor(
                    "Konstantin",
                    "Ivanov",
                    "ivanov@ya.com",
                    new InstructorDetail(
                            "IvanovElectronic.youtube.com",
                            "dancing"
                    )
            );

            var instructor2 = new Instructor(
                    "Dmitry",
                    "Sergeev",
                    "sergeev@gmail.ru",
                    new InstructorDetail(
                            "sergeev_java_tech.youtube.com",
                            "bicycle"
                    )
            );

            session.beginTransaction();
            session.save(instructor1);
            session.save(instructor2);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
