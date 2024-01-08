package com.example.project2.models;

import com.example.project2.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Order {
    private Integer id;
    private Integer numberOfProducts;
    private Double totalCost;
    private String deliveryAddress;
    private String dateOfSubmission;
    private Integer userId;
    private List<Integer> productsId;
}