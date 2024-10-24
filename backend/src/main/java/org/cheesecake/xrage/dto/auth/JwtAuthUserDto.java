package org.cheesecake.xrage.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthUserDto {

    private String username;
    private String password;
}
