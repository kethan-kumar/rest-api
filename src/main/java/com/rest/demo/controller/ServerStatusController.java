package com.rest.demo.controller;

import com.rest.demo.model.ServerStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ServerStatusController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/server")
    public ServerStatus greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ServerStatus(counter.incrementAndGet(), String.format(template, name));
    }
}
