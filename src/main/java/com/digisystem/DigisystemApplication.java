package com.digisystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DigisystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigisystemApplication.class, args);
    }

}
