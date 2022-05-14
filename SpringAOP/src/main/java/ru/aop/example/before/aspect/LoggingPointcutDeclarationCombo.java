package ru.aop.example.before.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingPointcutDeclarationCombo {

    /**
     * Pointcut for all methods
     */
    @Pointcut("execution(* ru.aop.example.before.dao3.*.*(..))")
    public void callDictionaryMethod() {}

    /**
     * Pointcut for getter methods
     */
    @Pointcut("execution(* ru.aop.example.before.dao3.*.get*(..))")
    public void callDictionaryGetter() {}

    /**
     * Pointcut for setter methods
     */
    @Pointcut("execution(* ru.aop.example.before.dao3.*.set*(..))")
    public void callDictionarySetter() {}

    /**
     * Excluded getter and setter
     */
    @Pointcut("!(callDictionarySetter() || callDictionaryGetter()) && callDictionaryMethod()")
    public void callDictionaryGettersAndSettersWithExcludeOtherMethods() {}


    @Before("callDictionaryGettersAndSettersWithExcludeOtherMethods()")
    public void log() {
        System.out.println(getClass() + " ====> Aspect Pointcut Before logging methods");
    }

    @Before("callDictionaryGettersAndSettersWithExcludeOtherMethods()")
    public void logSetter() {
        System.out.println(getClass() + " ====> Aspect Pointcut Before logging Setters");
    }

    @Before("callDictionaryGettersAndSettersWithExcludeOtherMethods()")
    public void logGetters() {
        System.out.println(getClass() + " ====> Aspect Pointcut Before logging Getters");
    }
}
