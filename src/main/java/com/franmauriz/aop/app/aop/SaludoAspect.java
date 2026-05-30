package com.franmauriz.aop.app.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class SaludoAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.franmauriz.aop.app.services.SaludoService.*(..))")
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes: " + method + " Args: " + arg);
    }

    @After("execution(String com.franmauriz.aop.app.services.SaludoService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues: " + method + " Args: " + arg);
    }

    @AfterReturning("execution(String com.franmauriz.aop.app.services.SaludoService.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de devolver return: " + method + " Args: " + arg);
    }

    @AfterThrowing("execution(String com.franmauriz.aop.app.services.SaludoService.*(..))")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de una exception: " + method + " Args: " + arg);
    }

    @Around("execution(String com.franmauriz.aop.app.services.SaludoService.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getSignature().getName();
        String arg = Arrays.toString(joinPoint.getArgs());
        Object result=null;
        try {
            logger.info("El metodo " + method + "() con los parametros " + arg);
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "() devuelve el resultado " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo " + method+"()");
            throw e;
        }
        
    }
}
