package org.cheesecake.xrage.service.impl;

import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.configuration.modelmapper.ModelMapperWrapper;
import org.cheesecake.xrage.dto.user.UserCreationDto;
import org.cheesecake.xrage.dto.user.UserDto;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.exception.extended.ValidationException;
import org.cheesecake.xrage.repository.UserRepository;
import org.cheesecake.xrage.service.face.UserService;
import org.cheesecake.xrage.utils.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapperWrapper modelMapper;

    @Override
    public UserDto create(UserCreationDto userDto) {
        validateUser(userDto);
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    private void validateUser(UserCreationDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ValidationException("Username and password cannot be empty!");
        }
        if (userRepository.findByUsername(username).isPresent()) {
            throw new ValidationException("Username already exists");
        }
    }
}
