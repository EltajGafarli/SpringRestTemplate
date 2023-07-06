package com.example.tryfeingclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TryFeingClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryFeingClientApplication.class, args);
    }

}
