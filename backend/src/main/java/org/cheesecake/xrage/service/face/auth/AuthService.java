package org.cheesecake.xrage.service.face.auth;

import org.cheesecake.xrage.dto.auth.JwtAuthUserDto;
import org.cheesecake.xrage.dto.auth.JwtRefreshDto;
import org.cheesecake.xrage.dto.auth.JwtResponseDto;

public interface AuthService {

    JwtResponseDto auth(JwtAuthUserDto jwtAuthUserDto);
    JwtResponseDto getAccessToken(JwtRefreshDto jwtRefreshDto);
}
