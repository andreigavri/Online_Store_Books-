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
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private UserRole role;
    private String avatar;
}
