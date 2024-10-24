package org.cheesecake.xrage.configuration.aop.auth;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.cheesecake.xrage.dto.auth.JwtAuthentication;
import org.cheesecake.xrage.exception.extended.UnauthorizedException;
import org.cheesecake.xrage.service.face.auth.JwtProviderService;
import org.cheesecake.xrage.utils.HttpUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static org.cheesecake.xrage.utils.StringUtils.isEmpty;

@RequiredArgsConstructor
@Aspect
@Component
public class JwtAuthAspect {

    private final JwtProviderService jwtProviderService;

    @Around("execution(* org.cheesecake.xrage.controller..*.*(..)) && !@annotation(org.cheesecake.xrage.configuration.aop.auth.ExcludeAuth)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String token = HttpUtils.getJwtTokenFromCurrentRequest();

        if (isEmpty(token) || !jwtProviderService.validateAccessToken(token)) {
            throw new UnauthorizedException();
        }

        Claims claims = jwtProviderService.getAccessClaims(token);
        JwtAuthentication jwtInfoToken = generate(claims);
        jwtInfoToken.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(jwtInfoToken);

        return joinPoint.proceed();
    }

    private JwtAuthentication generate(Claims claims) {
        JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }
}
