package org.cheesecake.xrage.auth.rights;

import org.cheesecake.xrage.entity.User;

import java.util.function.Predicate;

public enum Rights {
    ADMIN(User::isAdmin);

    private final Predicate<User> handler;

    Rights(Predicate<User> handler) {
        this.handler = handler;
    }

    public boolean check(User user) {
        return handler.test(user);
    }
}
