package com.example.project2.services;
import com.example.project2.entities.UserEntity;
import com.example.project2.models.User;
import java.util.List;

public interface UserService {
    //CRUD
    //CREATE
    User createRegularUser(User user);
    User createAdminUser(User user);
    //READ
    User getUserByLastName(String lastName);
    List<UserEntity> getAllUsers();
    User getUserById(Integer id);
    User getUserByEmail(String email);
    //UPDATE
    User updateUser(Integer id, User user);
    //DELETE
    void deleteUserById(Integer id);
    void deleteAllUsers();


}
