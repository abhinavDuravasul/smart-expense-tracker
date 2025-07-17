package com.smart.expense.tracker.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name ="exp_users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message ="UserName is required")
    @Size(max=35)
    @Column(name ="user_name")
    private String userName;

    @NotBlank(message ="Password is required")
    @Size(max=120)
    @Column(name= "password_hash")
    private String passwordHash; // store BCrypt hash, not raw password

    @NotBlank(message ="Email Id is required")
    @Size(max = 30)
    @Email(message ="Must be a valid e-mail address")
    @Column(name= "email_Id")
    private String email;

    @Column(name= "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name= "enabled")
    private boolean enabled = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name= "role")
    private Set<Role> roles = new HashSet<>();

}
