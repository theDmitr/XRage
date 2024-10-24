package org.cheesecake.xrage.service.impl.auth;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.dto.auth.JwtAuthUserDto;
import org.cheesecake.xrage.dto.auth.JwtRefreshDto;
import org.cheesecake.xrage.dto.auth.JwtResponseDto;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.exception.extended.IncorrectPasswordException;
import org.cheesecake.xrage.service.face.UserService;
import org.cheesecake.xrage.service.face.auth.AuthService;
import org.cheesecake.xrage.service.face.auth.JwtProviderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtProviderService jwtProviderService;

    private final Map<String, String> refreshStorage = new HashMap<>();

    @Override
    public JwtResponseDto auth(JwtAuthUserDto jwtAuthUserDto) {
        User user = userService.getByUsername(jwtAuthUserDto.getUsername());

        if (!user.getPassword().equals(jwtAuthUserDto.getPassword())) {
            throw new IncorrectPasswordException();
        }

        String accessToken = jwtProviderService.generateAccessToken(user);
        String refreshToken = jwtProviderService.generateRefreshToken(user);
        refreshStorage.put(user.getUsername(), refreshToken);

        return new JwtResponseDto(accessToken, refreshToken);
    }

    @Override
    public JwtResponseDto getAccessToken(JwtRefreshDto jwtRefreshDto) {
        String refreshToken = jwtRefreshDto.getRefreshToken();
        if (jwtProviderService.validateRefreshToken(refreshToken)) {
            Claims claims = jwtProviderService.getRefreshClaims(refreshToken);
            String username = claims.getSubject();
            String saveRefreshToken = refreshStorage.get(username);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                User user = userService.getByUsername(username);
                String accessToken = jwtProviderService.generateAccessToken(user);
                return new JwtResponseDto(accessToken, null);
            }
        }
        return new JwtResponseDto(null, null);
    }
}
