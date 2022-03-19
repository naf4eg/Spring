package ru.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Student;

public class PrimaryKeyDemoApp {

    static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure(HIBERNATE_CFG_FILE)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Create Students obj...");
            Student student1 = new Student("Maria", "Kukushkina", "maria@yandex.com");
            Student student2 = new Student("Denis", "Beketov", "denis@yandex.com");
            Student student3 = new Student("Alex", "Lovchek", "alex@yandex.com");
            session.beginTransaction();
            System.out.println("Saving the Students...");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
            System.out.println("Objects saved...");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
