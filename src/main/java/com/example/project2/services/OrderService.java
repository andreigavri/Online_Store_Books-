package com.example.project2.services;

import com.example.project2.entities.OrderEntity;
import com.example.project2.models.Order;
import java.util.List;

public interface OrderService {
    //Create
    Order createOrder(Order order);

    //READ
    Order getOrderById(Integer id);

    List<OrderEntity> getAllOrders();

    Order getOrderByDateOfSubmission(String dateOfSubmission);

    //UPDATE
    Order updateOrder(Integer id, Order order);

    //DELETE
    void deleteOrderById(Integer id);

    void deleteAllOrders();
}
