package org.cheesecake.xrage.auth.rights;

import org.cheesecake.xrage.entity.User;

import java.util.function.Function;

public enum Rights {
    ADMIN(User::isAdmin);

    private final Function<User, Boolean> handler;

    Rights(Function<User, Boolean> handler) {
        this.handler = handler;
    }

    public boolean check(User user) {
        return handler.apply(user);
    }
}
