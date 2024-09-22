package org.cheesecake.xrage.service.face;

import org.cheesecake.xrage.dto.membership.MembershipCreationDto;
import org.cheesecake.xrage.dto.membership.MembershipDto;

import java.util.List;

public interface MembershipService {

    List<MembershipDto> getAll();
    List<MembershipDto> getAllWithDeleted();
    MembershipDto getById(Long id);
    MembershipDto create(MembershipCreationDto membershipDto);
    MembershipDto update(Long membershipId, MembershipCreationDto membershipDto);
    void delete(Long membershipId);
}
