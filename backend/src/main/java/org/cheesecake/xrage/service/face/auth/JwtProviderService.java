package org.cheesecake.xrage.service.face.auth;

import io.jsonwebtoken.Claims;
import org.cheesecake.xrage.entity.User;

public interface JwtProviderService {

    String generateAccessToken(User user);
    String generateRefreshToken(User user);
    boolean validateAccessToken(String token);
    boolean validateRefreshToken(String token);
    Claims getAccessClaims(String token);
    Claims getRefreshClaims(String token);
}
