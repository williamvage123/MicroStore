package com.example.order.service;

import com.example.order.messaging.Producer;
import com.example.order.model.OrderModel;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Producer producer;


    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    // Old way of creating order
    /* public OrderModel createOrder(OrderModel orderModel) {
        return orderRepository.save(orderModel);
    } */

    // Create a new order and send a message to RabbitMQ
    public OrderModel createOrder(OrderModel orderModel) {
        // Save the order to the database
        OrderModel savedOrder = orderRepository.save(orderModel);

        // After saving, send the order to RabbitMQ using the Producer
        producer.sendMessage(savedOrder);

        return savedOrder;  // Return the saved order
    }


    public OrderModel getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
