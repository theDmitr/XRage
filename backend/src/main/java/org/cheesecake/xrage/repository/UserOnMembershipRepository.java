package org.cheesecake.xrage.repository;

import org.cheesecake.xrage.entity.UserOnMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOnMembershipRepository extends JpaRepository<UserOnMembership, Long> {
}
