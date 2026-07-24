package com.example.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthServiceApplication.class, args);
        System.out.println("=== JWT Authentication Service started on port 8083 ===");
        System.out.println("Login: POST http://localhost:8083/api/auth/login");
        System.out.println("Test: admin / password");
    }
}
