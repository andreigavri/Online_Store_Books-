package com.example.project2.entities;
import com.example.project2.models.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name ="_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Creates an automatic ID
    private Integer id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole role;
    @Column(name = "avatar")
    private String avatar;
}


