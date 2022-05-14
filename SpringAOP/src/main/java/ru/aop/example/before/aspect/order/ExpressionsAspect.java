package ru.aop.example.before.aspect.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExpressionsAspect {

    @Pointcut("execution(* ru.aop.example.before.dao4.*.find*(..))")
    public void sendElastic() {}

    @Pointcut("execution(* ru.aop.example.before.dao4.*.find*(..))")
    public void sendDB() {}

    @Pointcut("execution(* ru.aop.example.before.dao4.*.find*(..))")
    public void sendOtherSystem() {}
}
