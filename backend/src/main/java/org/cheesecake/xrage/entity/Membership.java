package org.cheesecake.xrage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private float cost;

    @Column
    private int duration;

    @Column
    private String description;

    @Column
    private boolean isWithTrainer;

    @Column
    private boolean isDelete;
}
