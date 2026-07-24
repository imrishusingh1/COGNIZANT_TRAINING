package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CountryService countryService) {
        return args -> {
            
            seedData(countryService);

            getAllCountriesTest(countryService);

            findCountryByCodeTest(countryService);

            testAddCountry(countryService);

            testUpdateCountry(countryService);

            testDeleteCountry(countryService);
        };
    }

    private void seedData(CountryService countryService) {
        LOGGER.info("=== Seeding initial country data ===");
        try {
            countryService.addCountry(new Country("IN", "India"));
            countryService.addCountry(new Country("US", "United States"));
            countryService.addCountry(new Country("GB", "United Kingdom"));
            countryService.addCountry(new Country("AU", "Australia"));
            countryService.addCountry(new Country("CA", "Canada"));
            countryService.addCountry(new Country("DE", "Germany"));
            countryService.addCountry(new Country("FR", "France"));
            countryService.addCountry(new Country("JP", "Japan"));
        } catch (Exception e) {
            LOGGER.error("Error seeding data: {}", e.getMessage());
        }
    }

    private void getAllCountriesTest(CountryService countryService) {
        LOGGER.info("Start - getAllCountriesTest");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries: {}", countries.size());
        countries.forEach(c -> LOGGER.debug("Country: {}", c));
        LOGGER.info("End - getAllCountriesTest");
    }

    private void findCountryByCodeTest(CountryService countryService) {
        LOGGER.info("Start - findCountryByCodeTest");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
            
            assert "India".equals(country.getName()) : "Country name mismatch!";
            LOGGER.info("Country found and verified: {}", country.getName());
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        LOGGER.info("End - findCountryByCodeTest");
    }

    private void testAddCountry(CountryService countryService) {
        LOGGER.info("Start - testAddCountry");
        Country newCountry = new Country("ZZ", "TestLand");
        countryService.addCountry(newCountry);
        try {
            Country found = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added country verified: {}", found);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Newly added country not found: {}", e.getMessage());
        }
        LOGGER.info("End - testAddCountry");
    }

    private void testUpdateCountry(CountryService countryService) {
        LOGGER.info("Start - testUpdateCountry");
        try {
            countryService.updateCountry("ZZ", "Updated TestLand");
            Country updated = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated country: {}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found for update: {}", e.getMessage());
        }
        LOGGER.info("End - testUpdateCountry");
    }

    private void testDeleteCountry(CountryService countryService) {
        LOGGER.info("Start - testDeleteCountry");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
            LOGGER.error("Country ZZ should have been deleted!");
        } catch (CountryNotFoundException e) {
            LOGGER.info("Country ZZ successfully deleted (not found as expected)");
        }
        LOGGER.info("End - testDeleteCountry");
    }
}
