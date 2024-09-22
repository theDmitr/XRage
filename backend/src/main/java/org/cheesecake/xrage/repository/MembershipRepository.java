package org.cheesecake.xrage.repository;

import org.cheesecake.xrage.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    @Query("FROM Membership WHERE NOT isDelete")
    List<Membership> findAllNotDeleted();
}
