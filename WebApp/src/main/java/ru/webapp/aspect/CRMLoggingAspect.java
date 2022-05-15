package ru.webapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class CRMLoggingAspect {

    @Pointcut("execution(* ru.webapp.controller.*.*(..))")
    private void controllerPointcut() {
    }

    @Pointcut("execution(* ru.webapp.dao.*.*(..))")
    private void daoPointcut() { }

    @Pointcut("execution(* ru.webapp.service.*.*(..))")
    private void servicesPointcut() { }

    @Pointcut("controllerPointcut() || daoPointcut() || servicesPointcut()")
    private void allPointcut() { }

    @Before("allPointcut()")
    public void loggerAdvice(JoinPoint joinPoint){
        var method = joinPoint.getSignature().toShortString();
        var args = joinPoint.getArgs();
        log.info("\n ===>> call method: " + method);
        Arrays.stream(joinPoint.getArgs()).forEach(arg -> log.info("\n ===>> arg: " + arg + "\n"));
    }
}
