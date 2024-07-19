package com.learning.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.learning.springbootaop.services.GreetingService.*(..))")
//    @Before("execution(* com.learning.springbootaop..*.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before ...." + method + " con los argumentos  .. " + args);
    }
    @After("execution(* com.learning.springbootaop.services.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After ...." + method + " con los argumentos  .. " + args);
    }

    @AfterReturning("execution(* com.learning.springbootaop.services.GreetingService.*(..))")
    public void AfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterReturning ...." + method + " con los argumentos  .. " + args);
    }
    @AfterThrowing("execution(* com.learning.springbootaop.services.GreetingService.*(..))")
    public void AfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("AfterThrowing ...." + method + " con los argumentos  .. " + args);
    }

    @Around("execution(* com.learning.springbootaop.services.*.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("Around ...." + method + "() con los argumentos  .. " + args);
            result = joinPoint.proceed();
            logger.info("Around ...." + method + "() con los argumentos  .. " + args + " ---  Resultado: " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo " + method + "()");
            throw e;
        }
    }
}
