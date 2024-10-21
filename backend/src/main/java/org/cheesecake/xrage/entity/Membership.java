package org.cheesecake.xrage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cheesecake.xrage.enums.MembershipType;

import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private MembershipType type;

    @Column
    private Integer duration;

    @Column
    private Integer availableVisits;
}
