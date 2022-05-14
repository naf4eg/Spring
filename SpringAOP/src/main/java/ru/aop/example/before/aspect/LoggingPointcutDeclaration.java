package ru.aop.example.before.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingPointcutDeclaration {

    /**
     * (anyType _ package . anyClass . anyMethods . (any number of parameters (zero or more)))
     */
    @Pointcut("execution(* ru.aop.example.before.dao2.*.*(..))")
    public void getLogVars() {}

    @Before("getLogVars()")
    public void beforeCallCars() {
        System.out.println("===>  Before 1 advice method logging with match - getLogVars()");
    }

    @Before("getLogVars()")
    public void beforeCallCars2() {
        System.out.println("===>  Before 2 advice method logging with match - getLogVars()");
    }
}
