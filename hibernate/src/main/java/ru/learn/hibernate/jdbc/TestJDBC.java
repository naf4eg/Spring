package ru.learn.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbc = "jdbc:postgresql://localhost:5432/hibernate?useSSL=false";
        String user = "hiber";
        String password = "password";

        try {
            System.out.println("Connect ===>>");

            DriverManager.getConnection(jdbc, user, password);

            System.out.println("Connection successful");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
