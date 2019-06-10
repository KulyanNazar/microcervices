package com.nazar.micro.organisation.controller;

import com.nazar.micro.organisation.client.CountryClient;
import com.nazar.micro.organisation.model.Country;
import com.nazar.micro.organisation.model.Organisation;
import com.nazar.micro.organisation.repository.OrganisationRepository;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@Api
public class OrganisationController {

    @Autowired
    CountryClient countryClient;

    @Autowired
    OrganisationRepository repository;

    @PostMapping("/")
    public Organisation add(@RequestBody Organisation organization) {
        log.info("adding organization: {}", organization);
        return repository.save(organization);
    }

    @GetMapping("/all")
    public List<Organisation> findAll() {
        log.info("get all organizations");
        List<Organisation> organisations = new ArrayList<>(repository.findAll());
        organisations
                .forEach(organisation -> organisation.setCountries(countryClient.findByOrganization(organisation.getId())));
        return organisations;
    }

    @GetMapping("/{id}")
    public Organisation findById(@PathVariable("id") Long id) {
        log.info("get organization with id: {}", id);
        Organisation organisation = repository.findById(id).get();
        organisation.setCountries(countryClient.findByOrganization(id));
        return organisation;
    }


    @GetMapping("/{id}/countries")
    public List<Country> findByIdWithCountries(@PathVariable("id") Long id) {
        log.info("get countries with organization id: {}", id);
        return countryClient.findByOrganization(id);
    }
}
