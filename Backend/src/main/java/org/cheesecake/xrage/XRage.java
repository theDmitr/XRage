package org.cheesecake.xrage;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.cheesecake.xrage.entity.User;
import org.cheesecake.xrage.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@SpringBootApplication
public class XRage {

    public static void main(String[] args) {
        SpringApplication.run(XRage.class, args);
    }

//    private final PasswordEncoder passwordEncoder;
//    private final UserRepository userRepository;
//    @PostConstruct
//    public void init() {
//        User user = new User();
//        user.setUsername("cheesecake");
//        user.setPassword(passwordEncoder.encode("cheesecake"));
//        userRepository.save(user);
//
//        User admin = new User();
//        admin.setUsername("admin");
//        admin.setPassword(passwordEncoder.encode("cheesecake"));
//        admin.setAdmin(true);
//        userRepository.save(admin);
//    }
}
