package org.cheesecake.xrage.service.face;

import org.cheesecake.xrage.dto.UserCreationDto;
import org.cheesecake.xrage.entity.User;

public interface UserService {

    User create(UserCreationDto userDto);
}
