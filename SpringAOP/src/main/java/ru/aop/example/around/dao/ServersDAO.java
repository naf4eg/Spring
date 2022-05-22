package ru.aop.example.around.dao;

import org.springframework.stereotype.Component;
import ru.aop.example.around.annotations.Monitoring;

@Component
public class ServersDAO {
    @Monitoring("CALL_SERVER_RU")
    public void callRuServer(boolean withException) throws Exception {
        if (withException) throw new Exception();
        try {
            System.out.println("Start call server1");
            Thread.sleep(2000);
            System.out.println("End call server1");
        } catch (Exception exception) {
            System.out.println("Error " + exception.getMessage());
        }
    }
}
