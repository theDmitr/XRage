package org.cheesecake.xrage.repository;

import org.cheesecake.xrage.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
