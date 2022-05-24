package ru.aop.example.around.dao;

import org.springframework.stereotype.Component;
import ru.aop.example.around.annotations.Monitoring;
import ru.aop.example.around.model.User;

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
    @Monitoring("CALL_SERVER_EN")
    public void callEnServer(User user, User user2) {
        System.out.println("Start call server2");
        System.out.println("End call server2");
    }
}
