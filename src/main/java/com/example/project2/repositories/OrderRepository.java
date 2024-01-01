package com.example.project2.repositories;

import com.example.project2.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    OrderEntity findByDateOfSubmission(String dateOfSubmission);
}
