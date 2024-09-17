package org.cheesecake.xrage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trainers_on_memberships")
public class TrainerOnMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private User trainer;

    @ManyToOne
    @JoinColumn(name = "active_membership_id")
    private ActiveMembership activeMembership;
}
