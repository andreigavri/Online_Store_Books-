package com.example.project2.services;

import com.example.project2.entities.UserEntity;
import com.example.project2.models.User;
import com.example.project2.models.UserRole;
import com.example.project2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository; // single Entity// because we used final // which allows only one single instance of the Repository

    @Autowired
    public UserServiceImpl(UserRepository userRepository) { // Dependency Injection / userService is directly correlated to userRepository// they both need to be connected otherwise will not make sense
        this.userRepository = userRepository;
    }


    @Override
    public User createRegularUser(User user) {
        user.setRole(UserRole.REGULAR);
        // 1. trasformam din User-ul primit cu numele "user" intr-un userEntity
        UserEntity userEntityDeSalavatInBaza = UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .avatar(user.getAvatar())
                .build();
        //2. salvam in baza de date - UserEntity - userRepository
        userRepository.save(userEntityDeSalavatInBaza);
        //3. transformam inapoi in user - ii facem udate lu' raluca
        user.setId(userEntityDeSalavatInBaza.getId());
        return user;
    }

    @Override
    public User createAdminUser(User user) {
        user.setRole(UserRole.ADMIN);
        // 1. trasformam din User-ul primit cu numele "user" intr-un userEntity
        UserEntity userEntityDeSalavatInBaza = UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .avatar(user.getAvatar())
                .build();
        //2. salvam in baza de date - UserEntity - userRepository
        userRepository.save(userEntityDeSalavatInBaza);
        //3. transformam inapoi in user - ii facem udate lu' raluca
        user.setId(userEntityDeSalavatInBaza.getId());
        return user;
    }

    @Override
    public User getUserByLastName(String lastName) {
        UserEntity entity = userRepository.findByLastName(lastName);
        User userReturnatDinDB = User.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .role(entity.getRole())
                .avatar(entity.getAvatar())
                .build();
        return userReturnatDinDB;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(Integer id) {
        Optional<UserEntity> optionalEntity = userRepository.findById(id); //Optional <> Container object in java- > that may have or may not contain a value
        if (optionalEntity.isPresent()) {
            UserEntity entity = optionalEntity.get();
            return User.builder()
                    .id(entity.getId())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .address(entity.getAddress())
                    .email(entity.getEmail())
                    .password(entity.getPassword())
                    .role(entity.getRole())
                    .avatar(entity.getAvatar())
                    .build();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email);
        User user = User.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .role(entity.getRole())
                .avatar(entity.getAvatar())
                .build();
        return user;
    }

    @Override
    public User updateUser(Integer id, User user) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            UserEntity userToUpdate = foundUser.get();
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setAddress(user.getAddress());
            userToUpdate.setPassword(user.getPassword());
            // need to add all properties.
            userRepository.save(userToUpdate);
            return user;
        }
        return null;
    }
    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}