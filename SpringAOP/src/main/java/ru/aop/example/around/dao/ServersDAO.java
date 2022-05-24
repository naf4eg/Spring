package ru.aop.example.around.dao;

import org.springframework.stereotype.Component;
import ru.aop.example.around.annotations.Monitoring;
import ru.aop.example.around.annotations.Using;
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
    public boolean callEnServer(User user) {
        System.out.println("Start call server2");
        user.getName();
        System.out.println("End call server2");
        return true;
    }
}
