package ru.aop.example.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.aop.example.around.annotations.Monitoring;
import ru.aop.example.around.model.User;

@Aspect
@Component
public class MonitoringAspect {

    @Around(value = "@annotation(monitor) && args(user,..)")
    public Object monitoringObject(ProceedingJoinPoint jp, Monitoring monitor, User user) throws Throwable {
        System.out.println("Start monitoring: " + monitor.value() + "\n");
        Object obj = jp.proceed();
        System.out.println("User: " + user);
        System.out.println("\nEnd monitoring: " + monitor.value());
        return obj;
    }
}
