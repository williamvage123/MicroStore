package com.example.order.messaging;

import com.example.order.model.OrderModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    // Exchange and routing key to send messages to RabbitMQ
    private static final String EXCHANGE = "order-exchange";
    private static final String ROUTING_KEY = "order-routing-key";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Method to send a message to RabbitMQ
    public void sendMessage(OrderModel order) {
        System.out.println("Sending message to RabbitMQ: " + order);

        // Use RabbitTemplate to send the order message to the specified exchange and routing key
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, order);
    }
}
