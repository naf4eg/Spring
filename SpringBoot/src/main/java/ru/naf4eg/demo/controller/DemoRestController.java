package ru.naf4eg.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@RestController
public class DemoRestController {

    @GetMapping("/")
    String sayHello() {
        return "Hello World " + "\n\n" + LocalDateTime.now() + "\n\n" + OffsetDateTime.now();
    }
}
