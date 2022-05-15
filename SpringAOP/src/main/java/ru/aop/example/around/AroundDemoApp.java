package ru.aop.example.around;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.around.configuration.AroundConfiguration;
import ru.aop.example.around.dao.ServersDAO;

public class AroundDemoApp {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AroundConfiguration.class);
        var serversDAO = ctx.getBean(ServersDAO.class);
        serversDAO.callRuServer(true);
    }
}
