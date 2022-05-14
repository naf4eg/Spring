package ru.aop.example.before.aspect.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(20)
public class MonitoringToOtherSysAspect {

    @Before("ru.aop.example.before.aspect.order.ExpressionsAspect.sendOtherSystem()")
    public void callOtherSys() {
        System.out.println(getClass() + " ====> call Other System");
    }
}
