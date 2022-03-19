package ru.learn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Student;

public class UpdateStudentDemoApp {

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
            System.out.println("Geting the Student...Id: " + STUDENT_ID);
            Student student = session.get(Student.class, STUDENT_ID);
            student.setFirsName("Lev");

            //second update variant
            session
                    .createQuery("update Student set email = 'Lev@yandex.com' where firsName = 'Lev'")
                    .executeUpdate();

            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
