package org.cheesecake.xrage.controller;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.configuration.aop.auth.ExcludeAuth;
import org.cheesecake.xrage.configuration.aop.rights.RequiresRight;
import org.cheesecake.xrage.configuration.aop.rights.Rights;
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

    @ExcludeAuth
    @GetMapping
    public List<MembershipDto> getAll() {
        return membershipService.getAll();
    }

    @RequiresRight(Rights.ADMIN)
    @GetMapping("/withDeleted")
    public List<MembershipDto> getAllWithDeleted() {
        return membershipService.getAllWithDeleted();
    }

    @GetMapping("/{membershipId}")
    public MembershipDto get(@PathVariable Long membershipId) {
        return membershipService.getById(membershipId);
    }

    @RequiresRight(Rights.ADMIN)
    @PostMapping
    public MembershipDto create(@RequestBody MembershipCreationDto membershipDto) {
        return membershipService.create(membershipDto);
    }

    @RequiresRight(Rights.ADMIN)
    @PatchMapping("/{membershipId}")
    public MembershipDto update(@PathVariable Long membershipId, @RequestBody MembershipCreationDto membershipDto) {
        return membershipService.update(membershipId, membershipDto);
    }

    @RequiresRight(Rights.ADMIN)
    @DeleteMapping("/{membershipId}")
    public void delete(@PathVariable Long membershipId) {
        membershipService.delete(membershipId);
    }
}
