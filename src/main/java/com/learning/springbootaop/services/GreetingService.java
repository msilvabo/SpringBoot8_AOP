package com.learning.springbootaop.services;

import org.springframework.stereotype.Service;

@Service
public interface GreetingService {
    String sayHello(String person, String greeting);
    String sayHelloError(String person, String greeting);
}
