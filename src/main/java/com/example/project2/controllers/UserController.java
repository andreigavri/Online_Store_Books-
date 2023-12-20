package com.example.project2.controllers;

import com.example.project2.entities.UserEntity;
import com.example.project2.models.User;
import com.example.project2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    //This line declares a private instance variable named "userService" of type UserService
    // final keyword indicates that once this variable is assigned a value, it cannot be reassigned
    @Autowired//This is a Spring Framework annotation used for automatic dependency injection
    // in the context of a Spring app, it marks a constructor
    // field or setter method to be autowired by Spring depndency injection
    public UserController(UserService userServiceImpl)
    //This is a constructor for a class named UserController.
    //It takes a parameter of Type UserService named userServiceImpl
    {
        this.userService = userServiceImpl;
    }
    //Inside the constructor, it assigns the value of the userServiceImpl parameter to the userService instance variable.

    @PostMapping("/regular")

    public User createNewRegularUser(@RequestBody User user) {
        return userService.createRegularUser(user);
    }

    @PostMapping("/admin")

    public User createNewAdminUser(@RequestBody User user) {
        return userService.createAdminUser(user);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{id}")
    public User updateUserDetails(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping
    public ResponseEntity deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsersById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();

    }
}





