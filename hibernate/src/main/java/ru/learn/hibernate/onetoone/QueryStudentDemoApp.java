package ru.learn.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Student;

import java.util.List;

public class QueryStudentDemoApp {

    static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure(HIBERNATE_CFG_FILE)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session
                    .createQuery("from Student")
                    .getResultList()
                    .forEach(System.out::println);
            System.out.println("===================================");
            session
                    .createQuery("from Student where lastName = 'Beketov'")
                    .getResultList()
                    .forEach(System.out::println);
            System.out.println("===================================");
            session
                    .createQuery("from Student where lastName = 'Beketov' or firsName = 'Mike'")
                    .getResultList()
                    .forEach(System.out::println);
            System.out.println("===================================");
            session
                    .createQuery("from Student where email LIKE '%yandex.com'")
                    .getResultList()
                    .forEach(System.out::println);
            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
