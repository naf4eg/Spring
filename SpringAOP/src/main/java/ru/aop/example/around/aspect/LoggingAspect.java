package ru.aop.example.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* ru.aop.example.around.dao.*.call*(..))")
    private void callServersDaoPointcut() {}

    @Around("callServersDaoPointcut()")
    public Object callAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            System.out.println("==>> Executing @Around method: " + proceedingJoinPoint.getSignature().toShortString());
            long beginTime = System.currentTimeMillis();
            Object result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long duration = endTime - beginTime;
            System.out.println("==>> Executed method for duration: " + duration + "\n\n");
            return result;
        } catch (Exception exc) {
            System.out.println("Exception!!!");
            throw  exc;
        }
    }
}
