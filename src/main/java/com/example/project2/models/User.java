package com.example.project2.models;

import com.example.project2.entities.OrderEntity;
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
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private UserRole role;
    private String avatar;
    private List<OrderEntity> orders;
}
