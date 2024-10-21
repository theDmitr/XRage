package org.cheesecake.xrage.controller;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.configuration.aop.auth.ExcludeAuth;
import org.cheesecake.xrage.dto.UserCreationDto;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.service.face.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    @ExcludeAuth
    @PostMapping("/register")
    public User register(@RequestBody UserCreationDto userDto) {
        return userService.register(userDto);
    }

    @PostMapping("/auth")
    public void auth() {
    }
}
