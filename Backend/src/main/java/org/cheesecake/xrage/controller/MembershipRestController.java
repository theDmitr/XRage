package org.cheesecake.xrage.controller;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.auth.rights.RequiresRights;
import org.cheesecake.xrage.auth.rights.Rights;
import org.cheesecake.xrage.dto.membership.MembershipCreationDto;
import org.cheesecake.xrage.dto.membership.MembershipDto;
import org.cheesecake.xrage.service.face.MembershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/membership")
public class MembershipRestController {

    private final MembershipService membershipService;

    @GetMapping
    public List<MembershipDto> getAll() {
        return membershipService.getAll();
    }

    @GetMapping("/withDeleted")
    public List<MembershipDto> getAllWithDeleted() {
        return membershipService.getAllWithDeleted();
    }

    @GetMapping("/{membershipId}")
    public MembershipDto get(@PathVariable Long membershipId) {
        return membershipService.getById(membershipId);
    }

    @RequiresRights(Rights.ADMIN)
    @PostMapping
    public MembershipDto create(@RequestBody MembershipCreationDto membershipDto) {
        return membershipService.create(membershipDto);
    }

    @RequiresRights(Rights.ADMIN)
    @PatchMapping("/{membershipId}")
    public MembershipDto update(@PathVariable Long membershipId, @RequestBody MembershipCreationDto membershipDto) {
        return membershipService.update(membershipId, membershipDto);
    }

    @RequiresRights(Rights.ADMIN)
    @DeleteMapping("/{membershipId}")
    public void delete(@PathVariable Long membershipId) {
        membershipService.delete(membershipId);
    }
}
