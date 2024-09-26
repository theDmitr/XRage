package org.cheesecake.xrage.configuration.aop.rights;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.exception.extended.RightsException;
import org.cheesecake.xrage.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Aspect
@Component
public class RightsControllerAspect {

    private final UserRepository userRepository;

    @Before("@annotation(org.cheesecake.xrage.configuration.aop.rights.RequiresRight)")
    public void requiresRightsHandler(JoinPoint p) {
        RequiresRight requiresRight = ((MethodSignature) p.getSignature()).getMethod().getAnnotation(RequiresRight.class);
        Rights[] rights = requiresRight.value();
        User user = currentUser();
        boolean hasRights = Arrays.stream(rights).anyMatch(r -> r.check(user));
        if (!hasRights) {
            throw new RightsException();
        }
    }

    private User currentUser() {
        String username = ((UserDetails) (SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal()))
                .getUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
