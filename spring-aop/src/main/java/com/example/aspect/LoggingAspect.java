package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.dao.*.get*(..))")
    public void logActivity(JoinPoint joinPoint) {
        String methodName =
            joinPoint.getSignature().getDeclaringTypeName() +
            "." +
            joinPoint.getSignature().getName();
        System.out.println("The " + methodName + " method was called.");
    }
}