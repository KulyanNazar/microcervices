package com.nazar.micro.organisation;

import com.google.common.collect.Lists;
import com.nazar.micro.organisation.model.Organisation;
import com.nazar.micro.organisation.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class OrganisationApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(OrganisationApplication.class, args);
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nazar.micro.organisation.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Organization API").description("Documentation Organization API v1.0").build());
    }

    @Autowired
    OrganisationRepository repository;

    @Override
    public void run(ApplicationArguments args) {
        List<Organisation> organisationList = Lists.newArrayList(
                new Organisation(1L, "NATO", null),
                new Organisation(2L, "NAFTA", null),
                new Organisation(3L, "UN", null));
        organisationList.forEach(repository::save);
    }
}

