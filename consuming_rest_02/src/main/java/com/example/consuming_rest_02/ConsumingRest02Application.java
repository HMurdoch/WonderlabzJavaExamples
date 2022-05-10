package com.example.consuming_rest_02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRest02Application {
    private static final Logger log = LoggerFactory.getLogger(ConsumingRest02Application.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRest02Application.class, args);
    }

    /**
     * Uses JSON processing to process incoming data
     * @param builder
     * @return A builder
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * A runner to run the RestTemplate
     * @param restTemplate
     * @return A CommandLineRunner
     * @throws Exception
     */
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        Quote defaultQuote = new Quote();
        return args -> {
            Quote quote = restTemplate.getForObject("http://localhost:8082/quote", Quote.class);
            log.info(quote.toString());
        };
    }
}
