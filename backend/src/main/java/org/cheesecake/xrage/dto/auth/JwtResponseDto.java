package org.cheesecake.xrage.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponseDto {

    private String accessToken;
    private String refreshToken;
}
