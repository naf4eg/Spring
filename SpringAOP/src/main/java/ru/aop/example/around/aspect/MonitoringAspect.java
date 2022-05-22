package ru.aop.example.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.aop.example.around.annotations.Monitoring;

@Aspect
@Component
public class MonitoringAspect {

    @Around("@annotation(monitor)")
    public Object monitoringObject(ProceedingJoinPoint jp, Monitoring monitor) throws Throwable {
        System.out.println("Start monitoring: " + monitor.value() + "\n");
        Object obj = jp.proceed();
        System.out.println("\nEnd monitoring: " + monitor.value());
        return obj;
    }
}
