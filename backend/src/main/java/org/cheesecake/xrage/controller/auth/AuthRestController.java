package org.cheesecake.xrage.controller.auth;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.configuration.aop.auth.ExcludeAuth;
import org.cheesecake.xrage.dto.auth.JwtAuthUserDto;
import org.cheesecake.xrage.dto.auth.JwtRefreshDto;
import org.cheesecake.xrage.dto.auth.JwtResponseDto;
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

    @ExcludeAuth
    @PostMapping("/token")
    public JwtResponseDto token(@RequestBody JwtRefreshDto jwtRefreshDto) {
        return authService.getAccessToken(jwtRefreshDto);
    }
}
