package com.learning.springbootaop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String sayHello(String person, String greeting) {
        String greet = "Hola don " + person + " " + greeting;
        return greet;
    }
}
