package org.cheesecake.xrage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Float price;

    @Column
    private Integer duration;

    @Column
    private String description;

    @Column
    private LocalDateTime createdAt;
}
