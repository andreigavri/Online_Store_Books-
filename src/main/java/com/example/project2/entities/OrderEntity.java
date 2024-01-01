package com.example.project2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "number_of_products", nullable = false, updatable = true)
        private Integer numberOfProducts;

        @Column(name = "total_cost", nullable = false, updatable = true)
        private Double totalCost;

        @Column(name = "delivery_address", nullable = true, updatable = true)
        private String deliveryAddress;

        @Column(name = "date_of_submission", nullable = true, updatable = true)
        private String dateOfSubmission;

//    @Column(name = "User_id", nullable = false, updatable = true)
//    private User user;
    }

