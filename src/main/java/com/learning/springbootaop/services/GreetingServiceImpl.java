package com.learning.springbootaop.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    private static final Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);

    @Override
    public String sayHello(String person, String greeting) {
        String greet = "Hola don " + person + " " + greeting;
        log.info(greet);
        return greet;
    }
}
