package com.practica.ECS;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class APIController {

    private static final String template = "Welcome to Containers, %s!";

    @GetMapping("/")
    public Message getMessage(@RequestParam(value = "name", defaultValue = "Awesome") String name) {
        return new Message(String.format(template, name));
    }

}
