package com.rw.restserver.controller;

import com.rw.restserver.model.User;
import com.rw.restserver.service.HelloWorldSvc;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
    private final HelloWorldSvc helloWorldSvc;

    public HelloWorldController(HelloWorldSvc helloWorldSvc) {
        this.helloWorldSvc = helloWorldSvc;
    }

    // GET /api/hello
    @GetMapping("/hello")
    public String helloGet() {
        return helloWorldSvc.getHelloWorld();
    }

    // POST /api/hello  with JSON body: {"name":"Jim"}
    @PostMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String helloPost(@RequestBody HelloRequest request) {
        return helloWorldSvc.greet(request == null ? null : request.name());
    }

    // GET /api/user - returns JSON {"name":"Jim"}
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser() {
        return helloWorldSvc.getUser();
    }

    public record HelloRequest(String name) {}
}


