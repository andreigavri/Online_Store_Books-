package com.example.project2.services;

import com.example.project2.entities.OrderEntity;
import com.example.project2.models.OrderD;
import com.example.project2.models.Product;

import java.util.List;

public interface OrderService {
    //Create
    OrderD createOrder(OrderD orderD);

    //READ
    OrderD getOrderById(Integer id);

    List<OrderEntity> getAllOrders();

    OrderD getOrderByDateOfSubmission(String dateOfSubmission);

    //UPDATE
    OrderD updateOrder(Integer id, OrderD orderD);

    //DELETE
    void deleteOrderById(Integer id);

    void deleteAllOrders();
}
