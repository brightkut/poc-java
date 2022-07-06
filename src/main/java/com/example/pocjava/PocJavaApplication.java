package com.example.pocjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PocJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocJavaApplication.class, args);
    }

}
