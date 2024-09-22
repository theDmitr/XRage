package org.cheesecake.xrage.auth.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cheesecake.xrage.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;

    public UserDetailsImpl(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
