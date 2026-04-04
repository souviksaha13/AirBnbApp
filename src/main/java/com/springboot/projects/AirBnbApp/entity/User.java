package com.springboot.projects.AirBnbApp.entity;

import com.springboot.projects.AirBnbApp.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "app_user")   // postgresql doesn't allow to create a table with name user
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;    // will encode it later

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
