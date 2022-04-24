package ru.aop.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice1(){
        System.out.println("===>  Before advice method logging with match - execution(public void addAccount())");
    }

    @Before("execution(public void ru.aop.example.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice2(){
        System.out.println("===>  Before advice method logging with match - execution(public void ru.aop.example.dao.AccountDAO.addAccount())");
    }

    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice3(){
        System.out.println("===>  Before advice method logging with match - execution(public void add*())");
    }

    @Before("execution(* add*())")
    public void beforeAddAccountAdvice4(){
        System.out.println("===>  Before advice method logging with match - execution(any Type add*())");
    }

    @Before("execution(* add*(ru.aop.example.model.Account))")
    public void beforeAddAccountAdvice5(){
        System.out.println("===>  Before advice method logging with match - execution(any Type add*(ru.aop.example.model.Account))");
    }

    @Before("execution(* add*(ru.aop.example.model.Account, ..))")
    public void beforeAddAccountAdvice6(){
        System.out.println("===>  Before advice method logging with match - execution(any Type add*(ru.aop.example.model.Account, ..))");
    }
}
