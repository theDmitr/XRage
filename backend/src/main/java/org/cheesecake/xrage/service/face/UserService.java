package org.cheesecake.xrage.service.face;

import org.cheesecake.xrage.dto.user.UserCreationDto;
import org.cheesecake.xrage.dto.user.UserDto;

public interface UserService {

    UserDto create(UserCreationDto userDto);
}
