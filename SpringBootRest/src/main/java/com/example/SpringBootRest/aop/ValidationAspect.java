package com.example.SpringBootRest.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.SpringBootRest.service.JobService.getJob(..)) && args(postID)")
    public Object validateandupdate(ProceedingJoinPoint jp, int postID ) throws Throwable {
        if(postID < 0){
            LOGGER.info("Post is negative,updated");
            postID = -postID;
            LOGGER.info("Value updated");
        }

        Object obj = jp.proceed(new Object[]{postID});

        return obj;

    }

}
