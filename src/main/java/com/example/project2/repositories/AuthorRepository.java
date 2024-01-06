package com.example.project2.repositories;

import com.example.project2.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    AuthorEntity findByLastName(String lastName);
}
