package com.example.practisewithoutsequrity.LoggingToConsole;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLoggingAspect {

    @Around("execution(* com.example.practisewithoutsequrity.*.*(..))")
    public Object logMethodName(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Выполняется метод: " + methodName);
        Object result = joinPoint.proceed();
        System.out.println("Метод " + methodName + " выполнен");
        return result;
    }
}