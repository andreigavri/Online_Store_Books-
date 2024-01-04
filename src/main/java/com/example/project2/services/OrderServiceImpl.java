package com.example.project2.services;
import com.example.project2.entities.OrderEntity;
import com.example.project2.models.Order;
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
    public Order createOrder(Order order) {
        OrderEntity orderEntityToSaveInDb = OrderEntity.builder()
                .numberOfProducts(order.getNumberOfProducts())
                .totalCost(order.getTotalCost())
                .deliveryAddress(order.getDeliveryAddress())
                .dateOfSubmission(order.getDateOfSubmission())
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
