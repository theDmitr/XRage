package org.cheesecake.xrage.service.impl;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.entity.Membership;
import org.cheesecake.xrage.repository.MembershipRepository;
import org.cheesecake.xrage.service.face.MembershipService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;

    @Override
    public List<Membership> getAll() {
        return membershipRepository.findAll();
    }
}
