package com.study.ducky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DuckyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuckyApplication.class, args);
    }

}
