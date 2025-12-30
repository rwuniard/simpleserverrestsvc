package com.rw.restserver.service;

import com.rw.restserver.model.User;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloWorldSvc {
    public String getHelloWorld() {
        log.info("Getting Hello World");
        return "Hello World";
    }

    public String greet(String name) {
        String safeName = (name == null || name.isBlank()) ? "World" : name.trim();
        log.info("Greeting {}", safeName);
        return "Hello " + safeName;
    }

    public User getUser() {
        log.info("Getting user");
        return new User("Jim");
    }
}
