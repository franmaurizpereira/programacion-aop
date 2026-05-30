package com.franmauriz.aop.app.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@Aspect
public class SaludoAspectNext {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.franmauriz.aop.app.services.SaludoService.*(..))")
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes: " + method + " desde Aspecto SaludosAspectNext Args: " + arg);
    }

    @After("execution(String com.franmauriz.aop.app.services.SaludoService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues: " + method + " desde Aspecto SaludosAspectNextArgs: " + arg);
    }

}
