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
}
