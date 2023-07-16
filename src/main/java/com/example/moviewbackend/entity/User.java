package com.example.moviewbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column
    private String profile;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING) // Enum 타입 저장할때 사용
    private UserRoleEnum role;

    public User (String email, String password) {
        this.email = email;
        this.password = password;
    }
}
