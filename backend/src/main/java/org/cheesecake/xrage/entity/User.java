package org.cheesecake.xrage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String creationDate;

    @Column
    private String birthday;

    @Column
    private boolean isAdmin;
}
