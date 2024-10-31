package org.cheesecake.xrage.service.impl.auth;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.exception.extended.IncorrectPasswordException;
import org.cheesecake.xrage.model.auth.JwtAuthUserDto;
import org.cheesecake.xrage.model.auth.JwtResponseDto;
import org.cheesecake.xrage.service.face.UserService;
import org.cheesecake.xrage.service.face.auth.AuthService;
import org.cheesecake.xrage.service.face.auth.JwtProviderService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtProviderService jwtProviderService;

    @Override
    public JwtResponseDto auth(JwtAuthUserDto jwtAuthUserDto) {
        User user = userService.getByUsername(jwtAuthUserDto.getUsername());
        if (!user.getPassword().equals(jwtAuthUserDto.getPassword())) {
            throw new IncorrectPasswordException();
        }
        String accessToken = jwtProviderService.generateToken(user);
        return new JwtResponseDto(accessToken);
    }
}
