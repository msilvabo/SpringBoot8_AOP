package com.learning.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String com.learning.springbootaop.services.GreetingService.sayHello(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes ...." + method + " con los argumentos  .. " + args);
    }
    @After("execution(String com.learning.springbootaop.services.GreetingService.sayHello(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues ...." + method + " con los argumentos  .. " + args);
    }
    @AfterReturning("execution(String com.learning.springbootaop.services.GreetingService.sayHello(..))")
    public void AfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues Retorno ...." + method + " con los argumentos  .. " + args);
    }
}