package org.cheesecake.xrage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "active_member_ships")
public class ActiveMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private boolean isDelete;
}
