package com.example.rabbitmq_broker_03;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * A simple POJO that defines a method for receiving messages
 */
@Component
public class Receiver {
    // Lets the POJO signal that the message has been received [Not likely in prod]
    private CountDownLatch latch = new CountDownLatch(1);

    /**
     * Receiver that responds to published methods
     * @param message Message object received.
     */
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
