package org.cheesecake.xrage.service.impl;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.dto.user.UserCreationDto;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.repository.UserRepository;
import org.cheesecake.xrage.service.face.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(UserCreationDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }
}
