package org.cheesecake.xrage;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class XRage {

    public static void main(String[] args) {
        SpringApplication.run(XRage.class, args);
    }
//
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
