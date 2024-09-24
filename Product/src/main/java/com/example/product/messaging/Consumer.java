package com.example.product.messaging;

import com.example.order.model.OrderModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    // This method listens to messages from RabbitMQ on the "order-queue"
    @RabbitListener(queues = "order-queue")
    public void receiveMessage(OrderModel order) {
        // Process the received order (e.g., update product inventory)
        System.out.println("Received order from RabbitMQ: " + order);

        // Here you can add logic to handle the order, such as updating the inventory
        // Example: updateInventory(order);
    }
}
