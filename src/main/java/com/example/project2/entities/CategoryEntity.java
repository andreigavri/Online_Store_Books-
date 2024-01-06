package com.example.project2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name ="_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name= "name_of_category", nullable = false, updatable = true)
    private String name;
    @OneToMany(mappedBy ="categoryEntity")
    private List<ProductEntity> products;
    @ManyToOne
    @JoinColumn(name="category_id")
    private AuthorEntity author;

}

