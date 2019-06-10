package com.nazar.micro.organisation.client;

import com.nazar.micro.organisation.model.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "country-service")
public interface CountryClient {

    @GetMapping("/country/organisations/{organisationId}")
    List<Country> findByOrganization(@PathVariable("organisationId") Long organisationId);
}
