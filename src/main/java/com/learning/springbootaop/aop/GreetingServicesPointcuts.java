package com.learning.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicesPointcuts {
    @Pointcut("execution(* com.learning.springbootaop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){
    }
    @Pointcut("execution(* com.learning.springbootaop.services.GreetingService.*(..))")
    public void greetingFooAspectPointCut(){
    }
}
