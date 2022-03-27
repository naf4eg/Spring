package ru.learn.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Student;

public class CreateStudentDemoApp {

    static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure(HIBERNATE_CFG_FILE)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Create Student obj...");
            Student student = new Student("Mike", "Gorky", "mike@yandex.com");
            session.beginTransaction();
            System.out.println("Saving the Student...");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Object saved...");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
