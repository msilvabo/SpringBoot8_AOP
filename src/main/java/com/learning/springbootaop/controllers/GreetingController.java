package com.learning.springbootaop.controllers;

import com.learning.springbootaop.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/app")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity greeting(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Pepito",", Hola don Jose")));
    }
    @GetMapping("/greetingError")
    public ResponseEntity greetingError(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHelloError("Pepito",", Hola don Jose")));
    }
}
