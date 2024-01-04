package com.example.project2.controllers;

import com.example.project2.entities.OrderEntity;
import com.example.project2.models.Order;
import com.example.project2.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderServiceImpl) {
        this.orderService = orderServiceImpl;
    }

    @PostMapping("/create")
    public Order createNewOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/allOrders")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("dateOfSubmission/{dateOfSubmission}")
    public Order getOrderByDateOfSubmission(@PathVariable String dateOfSubmission) {
        return orderService.getOrderByDateOfSubmission(dateOfSubmission);
    }

    @PutMapping("/{id}")
    public Order updateOrderDetails(@PathVariable Integer id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }
    @DeleteMapping
    public ResponseEntity deleteAllOrders() {
        orderService.deleteAllOrders();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderById(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }
}


