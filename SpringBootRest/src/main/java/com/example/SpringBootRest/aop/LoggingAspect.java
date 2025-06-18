package com.example.SpringBootRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);



    @Before("execution(* com.example.SpringBootRest.service.JobService.*(..))")
    public void LogMethodCall(JoinPoint jp){
        LOGGER.info("Method Called  " +jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.SpringBootRest.service.JobService.*(..))")
    public void LogMethodexecuted(JoinPoint jp){
        LOGGER.info("Method has some errors  " +jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.SpringBootRest.service.JobService.*(..))")
    public void LogMethodexecutedSuccess(JoinPoint jp){
        LOGGER.info("Method executed Successfully " +jp.getSignature().getName());
    }






}
