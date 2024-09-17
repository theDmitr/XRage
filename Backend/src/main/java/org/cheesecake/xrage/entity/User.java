package org.cheesecake.xrage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cheesecake.xrage.enums.UserRole;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
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
    private UserRole role;
}
