package ru.aop.example.aspect.joinpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.aop.example.model.Employee;

import java.util.Arrays;

@Aspect
@Component
public class JoinPointAspect {

    @Pointcut("execution(* ru.aop.example.dao5.*.set*(..))")
    private void pc() {}

    @Before("pc()")
    public void callJoinPoint(JoinPoint joinPoint) {
        System.out.println("===>  callJoinPoint()");

        var signature = joinPoint.getSignature();
        System.out.println("call method: " + signature);

        Object[] args = joinPoint.getArgs();

        Arrays.stream(args).forEach(a -> System.out.println("arg print: " + a));
    }
}
