package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        LOGGER.info("Start - getAllCountries");
        List<Country> countries = countryRepository.findAll();
        LOGGER.debug("Countries fetched: {}", countries.size());
        LOGGER.info("End - getAllCountries");
        return countries;
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        LOGGER.info("Start - findCountryByCode: {}", countryCode);

        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }

        Country country = result.get();
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End - findCountryByCode");
        return country;
    }

    @Transactional
    public void addCountry(Country country) {
        LOGGER.info("Start - addCountry: {}", country);
        countryRepository.save(country);
        LOGGER.info("End - addCountry: country added with code {}", country.getCode());
    }

    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        LOGGER.info("Start - updateCountry: code={}, newName={}", code, newName);

        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }

        Country country = result.get();
        country.setName(newName);
        countryRepository.save(country);

        LOGGER.info("End - updateCountry: country {} updated to {}", code, newName);
    }

    @Transactional
    public void deleteCountry(String code) {
        LOGGER.info("Start - deleteCountry: code={}", code);
        countryRepository.deleteById(code);
        LOGGER.info("End - deleteCountry: country {} deleted", code);
    }
}
