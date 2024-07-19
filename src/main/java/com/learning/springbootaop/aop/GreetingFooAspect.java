package com.learning.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.learning.springbootaop.services.GreetingService.*(..))")
    private void greetingFooAspectPointCut(){
    }

    @Before("greetingFooAspectPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before GreetingFOO...." + method + " con los argumentos  .. " + args);
    }
    @After("greetingFooAspectPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After GreetingFOO ...." + method + " con los argumentos  .. " + args);
    }
}
