package com.nazar.micro.country;

import com.google.common.collect.Lists;
import com.nazar.micro.country.model.Country;
import com.nazar.micro.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableAutoConfiguration
public class CountryServiceApplication implements ApplicationRunner {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CountryServiceApplication.class).run(args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nazar.micro.country.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Country API").description("Documentation Country API v1.0").build());
    }

    @Autowired
    CountryRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Country> countryList = Lists.newArrayList(
                new Country(0L, "Ukraine", 40000000, "Kyiv", Arrays.asList(1L, 3L)),
                new Country(0L, "England", 40000000, "London", Arrays.asList(1L, 3L)),
                new Country(0L, "France", 40000000, "Paris", Arrays.asList(1L, 3L)),
                new Country(0L, "Germany", 40000000, "Berlin", Arrays.asList(1L, 3L)),
                new Country(0L, "Spain", 40000000, "Madrid", Arrays.asList(1L, 3L)),
                new Country(0L, "USA", 40000000, "Washington", Arrays.asList(1L, 2L, 3L)),
                new Country(0L, "Canada", 40000000, "Ottawa", Arrays.asList(1L, 2L, 3L)),
                new Country(0L, "Mexico", 40000000, "Mexico", Arrays.asList(2L, 3L)));
        countryList.forEach(repository::save);

    }
}
