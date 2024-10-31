package org.cheesecake.xrage.model.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthUserDto {

    private String username;
    private String password;
}
