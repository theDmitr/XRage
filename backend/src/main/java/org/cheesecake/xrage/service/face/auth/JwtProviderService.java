package org.cheesecake.xrage.service.face.auth;

import io.jsonwebtoken.Claims;
import org.cheesecake.xrage.entity.User;

public interface JwtProviderService {

    String generateToken(User user);
    boolean validateToken(String token);
    Claims getClaims(String token);
}
