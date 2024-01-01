package com.example.project2.services;

import com.example.project2.entities.OrderEntity;
import com.example.project2.models.OrderD;
import com.example.project2.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderD createOrder(OrderD orderD) {
        OrderEntity orderEntityToSaveInDb = OrderEntity.builder()
                .numberOfProducts(orderD.getNumberOfProducts())
                .totalCost(orderD.getTotalCost())
                .deliveryAddress(orderD.getDeliveryAddress())
                .dateOfSubmission(orderD.getDateOfSubmission())
                .build();
        orderRepository.save(orderEntityToSaveInDb);
        orderD.setId(orderEntityToSaveInDb.getId());
        return orderD;
    }

    @Override
    public OrderD getOrderById(Integer id) {
        Optional<OrderEntity> optionalEntity = orderRepository.findById(id);
        if (optionalEntity.isPresent()) {
            OrderEntity entity = optionalEntity.get();
            return OrderD.builder()
                    .id(entity.getId())
                    .numberOfProducts(entity.getNumberOfProducts())
                    .totalCost(entity.getTotalCost())
                    .deliveryAddress(entity.getDeliveryAddress())
                    .dateOfSubmission(entity.getDateOfSubmission())
                    .build();
        }
        return null;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderD getOrderByDateOfSubmission(String dateOfSubmission) {
        OrderEntity entity = orderRepository.findByDateOfSubmission(dateOfSubmission);
        OrderD orderToReturnFromDb = OrderD.builder()
                .id(entity.getId())
                .numberOfProducts(entity.getNumberOfProducts())
                .totalCost(entity.getTotalCost())
                .deliveryAddress(entity.getDeliveryAddress())
                .dateOfSubmission(entity.getDateOfSubmission())
                .build();
        return orderToReturnFromDb;
    }

    @Override
    public OrderD updateOrder(Integer id, OrderD orderD) {
        Optional<OrderEntity> foundOrder = orderRepository.findById(id);
        if (foundOrder.isPresent()) {
            OrderEntity orderToUpdate = foundOrder.get();
            orderToUpdate.setNumberOfProducts(orderD.getNumberOfProducts());
            orderToUpdate.setTotalCost(orderD.getTotalCost());
            orderToUpdate.setDeliveryAddress(orderD.getDeliveryAddress());
            orderToUpdate.setDateOfSubmission(orderD.getDateOfSubmission());
        }
        return null;
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
