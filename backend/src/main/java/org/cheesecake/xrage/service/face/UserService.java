package org.cheesecake.xrage.service.face;

import org.cheesecake.xrage.entity.User;

public interface UserService {

    User getByUsername(String username);
}
