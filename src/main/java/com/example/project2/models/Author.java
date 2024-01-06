package com.example.project2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@Builder
@Component
@NoArgsConstructor
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;

}
