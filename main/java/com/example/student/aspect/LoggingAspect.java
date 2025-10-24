package com.example.student.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.student.Service.StudentService.*(..))")
    public void studentServiceMethods() {}

    @Before("studentServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering method: {} with arguments: {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @AfterReturning(value = "studentServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Method {} executed successfully, return: {}",
                joinPoint.getSignature().getName(),
                result);
    }

    @AfterThrowing(value = "studentServiceMethods()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        log.error("Method {} threw exception: {}",
                joinPoint.getSignature().getName(),
                ex.getMessage());
    }

    @After("studentServiceMethods()")
    public void logAfterFinally(JoinPoint joinPoint) {
        log.info("Method {} finished execution.",
                joinPoint.getSignature().getName());
    }
}
