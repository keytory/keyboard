package com.keytory.keyboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KeyboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeyboardApplication.class, args);
    }

}
