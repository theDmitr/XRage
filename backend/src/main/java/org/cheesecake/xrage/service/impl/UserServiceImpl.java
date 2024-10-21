package org.cheesecake.xrage.service.impl;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.dto.UserCreationDto;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.exception.extended.ValidationException;
import org.cheesecake.xrage.repository.UserRepository;
import org.cheesecake.xrage.service.face.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.cheesecake.xrage.utils.StringUtils.isEmpty;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(UserCreationDto userDto) {
        validate(userDto);
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    private void validate(UserCreationDto userDto) {
        if (isEmpty(userDto.getUsername()) || isEmpty(userDto.getPassword())) {
            throw new IllegalArgumentException("Username or password cannot be empty");
        }
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new ValidationException("Username already exists");
        }
    }
}
