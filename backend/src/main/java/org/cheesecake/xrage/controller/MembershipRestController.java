package org.cheesecake.xrage.controller;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.configuration.aop.auth.ExcludeAuth;
import org.cheesecake.xrage.entity.Membership;
import org.cheesecake.xrage.service.face.MembershipService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/membership")
public class MembershipRestController {

    private final MembershipService membershipService;

    @ExcludeAuth
    @GetMapping
    public List<Membership> getAll() {
        return membershipService.getAll();
    }
}
