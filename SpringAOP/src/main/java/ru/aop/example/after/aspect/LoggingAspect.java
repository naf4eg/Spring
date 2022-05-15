package ru.aop.example.after.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.aop.example.after.model.Account;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* ru.aop.example.after.dao.*.find*(..))")
    private void accountDaoPointcut() {}

    @AfterReturning(
            pointcut = "accountDaoPointcut()",
            returning = "accounts"
    )
    public void logFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
        System.out.println(accounts);

        //example for modify result
        var account1 = accounts
                .stream()
                .filter(account -> account.getType() == Account.Type.DEPOSIT)
                .collect(Collectors.toList()).get(0);

        accounts.remove(account1);
        System.out.println(accounts);
    }

    @AfterThrowing(
            pointcut = "accountDaoPointcut()",
            throwing = "throwable"
    )
    public void logFindAccountThrowAdvice(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("====>>> FAILURE!!! On method: " + joinPoint.getSignature().toShortString());
        System.out.println("====>>> Throw: " + throwable);
    }

    @After("accountDaoPointcut()")
    public void logFindAccountAfterFinallyAdvice() {
        System.out.println("====>>> log after Finally Advice");
    }
}
