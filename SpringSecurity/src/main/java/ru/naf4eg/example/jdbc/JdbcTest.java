package ru.naf4eg.example.jdbc;

import java.sql.DriverManager;

public class JdbcTest {
    public static void main(String[] args) {
        String jdbc = "jdbc:postgresql://localhost:5432/spring_security_demo_bcrypt?useSSL=false";
        String user = "spring_security";
        String password = "123";

        try {
            System.out.print("Connect ===>>  ");

            DriverManager.getConnection(jdbc, user, password);

            System.out.println("Connection successful");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
