package ru.aop.example.after_returning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.aop.example.after_returning.model.Account;

import java.util.List;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* ru.aop.example.after_returning.dao.*.find*(..))")
    private void accountDaoPointcut() {}

    @AfterReturning(
            pointcut = "accountDaoPointcut()",
            returning = "accounts"
    )
    public void logFindAccounts(JoinPoint joinPoint, List<Account> accounts) {
        System.out.println(accounts);
    }
}
