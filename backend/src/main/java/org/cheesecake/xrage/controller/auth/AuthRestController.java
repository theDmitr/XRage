package org.cheesecake.xrage.controller.auth;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.configuration.aop.auth.ExcludeAuth;
import org.cheesecake.xrage.model.auth.JwtAuthUserDto;
import org.cheesecake.xrage.model.auth.JwtResponseDto;
import org.cheesecake.xrage.service.face.auth.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final AuthService authService;

    @ExcludeAuth
    @PostMapping
    public JwtResponseDto auth(@RequestBody JwtAuthUserDto jwtAuthUserDto) {
        return authService.auth(jwtAuthUserDto);
    }
}
