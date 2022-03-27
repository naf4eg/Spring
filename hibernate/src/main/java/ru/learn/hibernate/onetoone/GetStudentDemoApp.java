package ru.learn.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Student;

public class GetStudentDemoApp {

    static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure(HIBERNATE_CFG_FILE)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Create Student obj...");
            Student student = new Student("Get", "Student", "get@yandex.com");
            session.beginTransaction();
            System.out.println("Saving the Student...");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Object saved...Id: " + student.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting obj...Id: " + student.getId());
            Student student1 = session.get(Student.class, student.getId());
            System.out.println("Done get obj...");
            System.out.println(student1.toString());

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
