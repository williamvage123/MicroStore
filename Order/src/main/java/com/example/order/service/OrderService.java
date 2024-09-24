package com.example.order.service;

import com.example.order.model.OrderModel;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Get all orders
    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();  // This will fetch from DB when integrated
    }

    // Create a new order
    public OrderModel createOrder(OrderModel orderModel) {
        return orderRepository.save(orderModel);  // Save order to DB (or in-memory if H2)
    }

    // Find an order by ID
    public OrderModel getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Delete an order by ID
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
