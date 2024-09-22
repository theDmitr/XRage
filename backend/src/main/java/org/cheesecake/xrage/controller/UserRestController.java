package org.cheesecake.xrage.controller;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.dto.user.UserCreationDto;
import org.cheesecake.xrage.dto.user.UserDto;
import org.cheesecake.xrage.service.face.UserService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    @PostMapping("/register")
    public UserDto register(@RequestBody UserCreationDto userDto) {
        return userService.create(userDto);
    }
}
