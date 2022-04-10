package ru.webapp;

import org.postgresql.Driver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.DriverManager;

@WebServlet(name = "TestDBServlet", value = "/TestDBServlet")
public class TestDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbc = "jdbc:postgresql://localhost:5432/web_customer_tracker?useSSL=false";
        String user = "springstudent";
        String password = "springstudent";
        var out = response.getWriter();
        try {
            out.println("Connecting: " + jdbc);
            //Class.forName("org.postgresql.Driver");
            new Driver();
            var connection = DriverManager.getConnection(jdbc, user, password);
            out.println("SUCCESS!");
            connection.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
