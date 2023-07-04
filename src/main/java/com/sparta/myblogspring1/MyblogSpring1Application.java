package com.sparta.myblogspring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyblogSpring1Application {

    public static void main(String[] args) {
        SpringApplication.run(MyblogSpring1Application.class, args);
    }

}
