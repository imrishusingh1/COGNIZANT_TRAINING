package com.example.rest.controller;

import com.example.rest.model.Country;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private static final List<Country> countries = Arrays.asList(
        new Country("IN", "India"),
        new Country("US", "United States"),
        new Country("GB", "United Kingdom"),
        new Country("AU", "Australia"),
        new Country("CA", "Canada"),
        new Country("DE", "Germany"),
        new Country("FR", "France"),
        new Country("JP", "Japan"),
        new Country("CN", "China"),
        new Country("BR", "Brazil")
    );

    @GetMapping
    public List<Country> getAllCountries() {
        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Country not found: " + code));
    }

    @GetMapping("/xml-config")
    public Country getCountryFromXmlConfig() {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("country-config.xml")) {
            return (Country) context.getBean("country");
        }
    }
}
