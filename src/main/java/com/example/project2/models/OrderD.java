package com.example.project2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class OrderD {
    private Integer id;
    private Integer numberOfProducts;
    private Double totalCost;
    private String deliveryAddress;
    private String dateOfSubmission;
}