package ru.aop.example.after_returning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.aop.example.after_returning.model.Account;

import java.util.List;
import java.util.stream.Collectors;

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

        //example for modify result
        var account1 = accounts
                .stream()
                .filter(account -> account.getType() == Account.Type.DEPOSIT)
                .collect(Collectors.toList()).get(0);

        accounts.remove(account1);
        System.out.println(accounts);
    }
}
