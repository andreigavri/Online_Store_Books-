package com.example.project2.repositories;
import com.example.project2.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> { // <UserEntity> Type <Integer> ID
    UserEntity findByLastName(String lastName);
    UserEntity findByEmail(String email);

}
