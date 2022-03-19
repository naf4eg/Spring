package ru.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Student;

public class DeleteStudentDemoApp {

    static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";
    private static final Long STUDENT_ID = 6L;

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure(HIBERNATE_CFG_FILE)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            System.out.println("Create Students...");
            Student student1 = new Student("Delete", "Deletovich", "deletovich@email.com");
            Student student2 = new Student("Deleting", "Deletovna", "deletovna@email.com");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved Students....");
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting all students...");
            session.createQuery("from Student").getResultList().forEach(System.out::println);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Deleting all students...");
            session.delete(student1);
            session.delete(student2);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("from Student").getResultList().forEach(System.out::println);
            session.getTransaction().commit();

            //Query realization
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Create Students...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved Students....");
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting all students...");
            session.createQuery("from Student").getResultList().forEach(System.out::println);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Deleting all students...");
            session
                    .createQuery("delete Student where firsName='Delete' or firsName='Deleting'")
                    .executeUpdate();
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("from Student").getResultList().forEach(System.out::println);
            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
