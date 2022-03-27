package ru.learn.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Course;
import ru.learn.hibernate.model.Instructor;
import ru.learn.hibernate.model.InstructorDetail;

public class CreateCoursesDemoApp {

    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

    private static final SessionFactory sessionFactory = new Configuration()
            .configure(HIBERNATE_CFG)
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    private static Session session;

    public static void main(String[] args) {
        try {
            session = sessionFactory.getCurrentSession();
            var instructor1 = new Instructor(
                    "Daria",
                    "Lihacheva",
                    "daria@ya.ru",
                    new InstructorDetail(
                           "daria.youtube.com",
                           "sky diver"
                    )
            );

            var instructor2 = new Instructor(
                    "Konstantin",
                    "Smirnov",
                    "kostya@ya.ru",
                    new InstructorDetail(
                            "smir_3232.youtube.com",
                            "electronic"
                    )
            );

            var course1 = new Course("QA Automatically");
            var course2 = new Course("Java developer");
            var course3 = new Course("Test Course");
            var course4 = new Course("Electronic");

            /**
             * инструктору добавить курс, а курсу добавить инструктора
             * добавка инструктора лучше в addCourse(course1)
             */
            course1.setInstructor(instructor1);
            course2.setInstructor(instructor1);
            instructor1.addCourse(course1);
            instructor1.addCourse(course2);

            course4.setInstructor(instructor2);
            instructor2.addCourse(course4);

            session.beginTransaction();
            session.save(instructor1);
            session.save(instructor2);
            session.save(course1);
            session.save(course2);
            session.save(course3);
            session.save(course4);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
