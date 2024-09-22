package org.cheesecake.xrage.service.impl;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.configuration.modelmapper.ModelMapperWrapper;
import org.cheesecake.xrage.dto.membership.MembershipCreationDto;
import org.cheesecake.xrage.dto.membership.MembershipDto;
import org.cheesecake.xrage.entity.Membership;
import org.cheesecake.xrage.exception.extended.NotFoundMembershipException;
import org.cheesecake.xrage.exception.extended.ValidationException;
import org.cheesecake.xrage.repository.MembershipRepository;
import org.cheesecake.xrage.service.face.MembershipService;
import org.cheesecake.xrage.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;
    private final ModelMapperWrapper modelMapper;

    @Override
    public List<MembershipDto> getAll() {
        return modelMapper.mapCollection(membershipRepository.findAllNotDeleted(), MembershipDto.class);
    }

    @Override
    public List<MembershipDto> getAllWithDeleted() {
        return modelMapper.mapCollection(membershipRepository.findAll(), MembershipDto.class);
    }

    @Override
    public MembershipDto getById(Long id) {
        Membership found = membershipRepository.findById(id)
                .orElseThrow(NotFoundMembershipException::new);
        return modelMapper.map(found, MembershipDto.class);
    }

    @Override
    public MembershipDto create(MembershipCreationDto membershipDto) {
        validateMembership(membershipDto);
        Membership membership = modelMapper.map(membershipDto, Membership.class);
        membership = membershipRepository.save(membership);
        return modelMapper.map(membership, MembershipDto.class);
    }

    @Override
    public MembershipDto update(Long id, MembershipCreationDto membershipDto) {
        validateMembership(membershipDto);
        Membership membership = modelMapper.map(membershipDto, Membership.class);
        membership.setId(id);
        membership = membershipRepository.save(membership);
        return modelMapper.map(membership, MembershipDto.class);
    }

    @Override
    public void delete(Long id) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(NotFoundMembershipException::new);
        membership.setDelete(true);
        membershipRepository.save(membership);
    }

    private void validateMembership(MembershipCreationDto membershipDto) {
        if (StringUtils.isEmpty(membershipDto.getName())) {
            throw new ValidationException("Membership name cannot be empty!");
        }
        if (membershipDto.getCost() < 0) {
            throw new ValidationException("Invalid cost!");
        }
        if (membershipDto.getDuration() < 0) {
            throw new ValidationException("Invalid duration!");
        }
    }
}
