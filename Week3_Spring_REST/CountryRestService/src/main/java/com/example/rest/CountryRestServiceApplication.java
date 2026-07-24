package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryRestServiceApplication.class, args);
        System.out.println("=== Country REST Service started on port 8082 ===");
        System.out.println("Hello World: http://localhost:8082/api/hello");
        System.out.println("All countries: http://localhost:8082/api/countries");
        System.out.println("By code: http://localhost:8082/api/countries/IN");
    }
}
