package com.example.project2.services;
import com.example.project2.entities.OrderEntity;
import com.example.project2.entities.ProductEntity;
import com.example.project2.models.Order;
import com.example.project2.repositories.OrderRepository;
import com.example.project2.repositories.ProductRepository;
import com.example.project2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order createOrder(Order order) {
        var user = userRepository.findById(order.getUserId());
        boolean userIsPresent = user.isPresent();

        boolean productsAreValid = true;
        List<ProductEntity> productEntities = new ArrayList<>();
        for (Integer productId : order.getProductsId()) {
            var product = this.productRepository.findById(productId);
            if (!product.isPresent()) {
                productsAreValid = false;
                break;
            }
            productEntities.add(product.get());
        }

        if (!userIsPresent || !productsAreValid) return null;

        OrderEntity orderEntityToSaveInDb = OrderEntity.builder()
                .numberOfProducts(order.getNumberOfProducts())
                .totalCost(order.getTotalCost())
                .deliveryAddress(order.getDeliveryAddress())
                .dateOfSubmission(order.getDateOfSubmission())
                .user(user.get())
                .products(productEntities)
                .build();
        orderRepository.save(orderEntityToSaveInDb);
        order.setId(orderEntityToSaveInDb.getId());
        return order;
    }

    @Override
    public Order getOrderById(Integer id) {
        Optional<OrderEntity> optionalEntity = orderRepository.findById(id);
        if (optionalEntity.isPresent()) {
            OrderEntity entity = optionalEntity.get();
            return Order.builder()
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
    public Order getOrderByDateOfSubmission(String dateOfSubmission) {
        OrderEntity entity = orderRepository.findByDateOfSubmission(dateOfSubmission);
        Order orderToReturnFromDb = Order.builder()
                .id(entity.getId())
                .numberOfProducts(entity.getNumberOfProducts())
                .totalCost(entity.getTotalCost())
                .deliveryAddress(entity.getDeliveryAddress())
                .dateOfSubmission(entity.getDateOfSubmission())
                .build();
        return orderToReturnFromDb;
    }

    @Override
    public Order updateOrder(Integer id, Order order) {
        Optional<OrderEntity> foundOrder = orderRepository.findById(id);
        if (foundOrder.isPresent()) {
            OrderEntity orderToUpdate = foundOrder.get();
            orderToUpdate.setNumberOfProducts(order.getNumberOfProducts());
            orderToUpdate.setTotalCost(order.getTotalCost());
            orderToUpdate.setDeliveryAddress(order.getDeliveryAddress());
            orderToUpdate.setDateOfSubmission(order.getDateOfSubmission());
            orderRepository.save(orderToUpdate);
            return order;
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
