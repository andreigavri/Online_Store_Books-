package com.example.project2.entities;

import jakarta.persistence.*;
import lombok.*;
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
    @Column(name= "name_of_category")
    private String name;

}

