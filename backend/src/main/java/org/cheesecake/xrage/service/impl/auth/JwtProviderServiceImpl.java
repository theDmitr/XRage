package org.cheesecake.xrage.service.impl.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import lombok.extern.slf4j.Slf4j;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.service.face.auth.JwtProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Slf4j
@Component
public class JwtProviderServiceImpl implements JwtProviderService {

    private final SecretKey jwtAccessSecretKey;
    private final SecretKey jwtRefreshSecretKey;

    public JwtProviderServiceImpl(@Value("${jwt.secret.access}") String jwtAccessSecretKey,
                                  @Value("${jwt.secret.refresh}") String jwtRefreshSecretKey) {
        this.jwtAccessSecretKey = hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecretKey));
        this.jwtRefreshSecretKey = hmacShaKeyFor(Decoders.BASE64.decode(jwtRefreshSecretKey));
    }

    @Override
    public String generateAccessToken(User user) {
        LocalDateTime now = LocalDateTime.now();
        Instant accessExpirationInstant = now.plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant();
        Date accessExpirationDate = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(accessExpirationDate)
                .signWith(jwtAccessSecretKey)
                .compact();
    }

    @Override
    public String generateRefreshToken(User user) {
        LocalDateTime now = LocalDateTime.now();
        Instant refreshExpirationInstant = now.plusDays(30).atZone(ZoneId.systemDefault()).toInstant();
        Date refreshExpirationDate = Date.from(refreshExpirationInstant);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(refreshExpirationDate)
                .signWith(jwtRefreshSecretKey)
                .compact();
    }

    @Override
    public boolean validateAccessToken(String token) {
        return validateToken(token, jwtAccessSecretKey);
    }

    @Override
    public boolean validateRefreshToken(String token) {
        return validateToken(token, jwtRefreshSecretKey);
    }

    private boolean validateToken(String token, Key secret) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired");
        } catch (Exception e) {
            log.error("Invalid token");
        }
        return false;
    }

    @Override
    public Claims getAccessClaims(String token) {
        return getClaims(token, jwtAccessSecretKey);
    }

    @Override
    public Claims getRefreshClaims(String token) {
        return getClaims(token, jwtRefreshSecretKey);
    }

    private Claims getClaims(String token, Key secret) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
