package ru.learn.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.learn.hibernate.model.Course;
import ru.learn.hibernate.model.Instructor;
import ru.learn.hibernate.model.InstructorDetail;
import ru.learn.hibernate.model.Review;

public class CreateCourseReviewsUniDirectionalDemoApp {

    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

    private static final SessionFactory sessionFactory = new Configuration()
            .configure(HIBERNATE_CFG)
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .buildSessionFactory();

    private static Session session;

    public static void main(String[] args) {
        try {
            session = sessionFactory.getCurrentSession();

            var course = new Course("Kotlin/Java course for Android developers");
            var review1 = new Review("WOW Great course!");
            var review2 = new Review("Not Bad course. This course helped me learn develop Android apps");
            var review3 = new Review("Bad course");

            System.out.println("Course: " + course);
            System.out.println("Review1: " + review1);
            System.out.println("Review2: " + review2);
            System.out.println("Review3: " + review3);

            course.addReview(review1);
            course.addReview(review2);
            course.addReview(review3);

            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
