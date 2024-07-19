package com.learning.springbootaop.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/app")
public class GreetingController {

    @GetMapping("/greeting")
    public ResponseEntity greeting(){
        return ResponseEntity.ok(Collections.singletonMap("greeting", "Hello World"));
    }
}
