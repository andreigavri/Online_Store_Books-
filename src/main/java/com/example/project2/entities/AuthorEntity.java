package com.example.project2.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "_authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", nullable = false, updatable = true)
    private String firstName;
    @Column(name = "last_name", nullable = false, updatable = true)
    private String lastName;
    @OneToMany(mappedBy = "auth")
    private List<ProductEntity>products;
}
