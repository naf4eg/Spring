package ru.aop.example.before.aspect.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class MonitoringToDBAspect {

    @Before("ru.aop.example.before.aspect.order.ExpressionsAspect.sendDB()")
    public void callDB() {
        System.out.println(getClass() + " ====> call DB");
    }
}
