package com.example.rabbitmq_broker_03;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Runner implements CommandLineRunner {

    private final Receiver receiver;
    private final RabbitTemplate rabbitTemplate;
    private final AtomicLong counter = new AtomicLong();

    /**
     * Constructor injecting receiver and template dependencies
     * @param receiver
     * @param rabbitTemplate
     */
    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("Sending message...");
            rabbitTemplate.convertAndSend(RabbitmqBroker03Application.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ <" + counter.incrementAndGet() + "> !");
        }
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
