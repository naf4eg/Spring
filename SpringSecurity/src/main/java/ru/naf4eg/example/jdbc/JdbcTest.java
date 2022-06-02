package ru.naf4eg.example.jdbc;

import java.sql.DriverManager;

public class JdbcTest {
    public static void main(String[] args) {
        String jdbc = "jdbc:postgresql://localhost:5432/spring_security_demo?useSSL=false";
        String user = "hiber";
        String password = "password";

        try {
            System.out.print("Connect ===>>  ");

            DriverManager.getConnection(jdbc, user, password);

            System.out.println("Connection successful");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
