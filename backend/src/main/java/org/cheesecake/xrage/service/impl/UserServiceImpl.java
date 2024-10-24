package org.cheesecake.xrage.service.impl;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.exception.extended.NotFoundUsernameException;
import org.cheesecake.xrage.repository.UserRepository;
import org.cheesecake.xrage.service.face.UserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(NotFoundUsernameException::new);
    }
}
