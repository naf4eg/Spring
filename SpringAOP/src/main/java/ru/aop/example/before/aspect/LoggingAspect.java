package ru.aop.example.before.aspect;

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

    @Before("execution(public void ru.aop.example.before.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice2(){
        System.out.println("===>  Before advice method logging with match - execution(public void ru.aop.example.before.dao.AccountDAO.addAccount())");
    }

    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice3(){
        System.out.println("===>  Before advice method logging with match - execution(public void add*())");
    }

    @Before("execution(* add*())")
    public void beforeAddAccountAdvice4(){
        System.out.println("===>  Before advice method logging with match - execution(any Type add*())");
    }

    @Before("execution(* add*(ru.aop.example.before.model.Account))")
    public void beforeAddAccountAdvice5(){
        System.out.println("===>  Before advice method logging with match - execution(any Type add*(ru.aop.example.before.model.Account))");
    }

    @Before("execution(* add*(ru.aop.example.before.model.Account, ..))")
    public void beforeAddAccountAdvice6(){
        System.out.println("===>  Before advice method logging with match - execution(any Type add*(ru.aop.example.before.model.Account, ..))");
    }

    @Before("execution(* add*(..))")
    public void beforeAddAccountAdvice7(){
        System.out.println("===>  Before advice method logging with match - execution(any Type and any Params add*(..))");
    }

    @Before("execution(* ru.aop.example.before.dao.*.*(..))")
    public void beforeAddAccountAdvice8(){
        System.out.println("===>  Before advice method logging with match - execution(* ru.aop.example.before.dao.*.*(..))");
    }
}
