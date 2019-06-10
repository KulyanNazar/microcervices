package com.nazar.micro.country.controller;

import com.nazar.micro.country.model.Country;
import com.nazar.micro.country.repository.CountryRepository;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Api
public class CountryController {

    @Autowired
    CountryRepository repository;

    @PostMapping("/")
    public Country add(@RequestBody Country country) {
        log.info("adding country: {}", country);
        return repository.save(country);
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable("id") Long id) {
        log.info("get country with id: {}", id);
        return repository.findById(id).get();
    }

    @GetMapping("/country/organisations/{organisationId}")
    public List<Country> getOrganisations(@PathVariable("organisationId") Long id) {
        log.info("get country by organisations id: {}", id);
        return repository.findByOrganisationIds(id);
    }

    @GetMapping("/")
    public List<Country> findAll() {
        log.info("get all coutries");
        return repository.findAll();
    }
}
