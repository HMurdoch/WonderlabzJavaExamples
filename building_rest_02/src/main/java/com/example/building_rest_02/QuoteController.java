package com.example.building_rest_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class QuoteController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * Quote method to consume the quote service
     * @return Return the default Quote data
     */
    @GetMapping("/quote")
    public Quote quote() {
        return new Quote();
    }
}
