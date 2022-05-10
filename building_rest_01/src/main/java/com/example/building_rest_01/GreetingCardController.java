package com.example.building_rest_01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingCardController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * Greeting method to return a message based on name and message content
     * @param name
     * @param content
     * @return Greeting with person's name and message
     */
    @GetMapping("/greeting")
    public GreetingCard greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "content", defaultValue = "Good Day to you") String content) {
        return new GreetingCard(counter.incrementAndGet(), String.format(template, name), content);
    }
}
