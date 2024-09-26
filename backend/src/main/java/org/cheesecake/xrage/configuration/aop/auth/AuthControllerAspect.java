package org.cheesecake.xrage.configuration.aop.auth;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.cheesecake.xrage.exception.extended.UnauthorizedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class AuthControllerAspect {

    @Around("execution(* org.cheesecake.xrage.controller..*.*(..)) && !@annotation(org.cheesecake.xrage.configuration.aop.auth.ExcludeAuth)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new UnauthorizedException();
        }
        return joinPoint.proceed();
    }
}
