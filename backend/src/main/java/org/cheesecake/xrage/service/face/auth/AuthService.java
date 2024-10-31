package org.cheesecake.xrage.service.face.auth;

import org.cheesecake.xrage.model.auth.JwtAuthUserDto;
import org.cheesecake.xrage.model.auth.JwtResponseDto;

public interface AuthService {

    JwtResponseDto auth(JwtAuthUserDto jwtAuthUserDto);
}
