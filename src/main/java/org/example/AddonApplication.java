package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories("org.example.repository")

public class AddonApplication {

    public static void main(String[] args) throws Exception {

        new SpringApplication(AddonApplication.class).run(args);

    }

}