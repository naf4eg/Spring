package ru.aop.example.aspect.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MonitoringToElasticAspect {

    @Before("ru.aop.example.aspect.order.ExpressionsAspect.sendElastic()")
    public void callElastic() {
        System.out.println(getClass() + " ====> call Elastic");
    }
}
