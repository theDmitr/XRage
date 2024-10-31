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
import java.time.Duration;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Slf4j
@Component
public class JwtProviderServiceImpl implements JwtProviderService {

    private final SecretKey jwtSecretKey;

    public JwtProviderServiceImpl(@Value("${jwt.secret}") String jwtSecretKey) {
        this.jwtSecretKey = hmacShaKeyFor(Decoders.BASE64.decode(jwtSecretKey));
    }

    @Override
    public String generateToken(User user) {
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + Duration.ofMinutes(1).toMillis()))
                .signWith(jwtSecretKey)
                .compact();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtSecretKey)
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
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
