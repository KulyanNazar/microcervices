package com.nazar.micro.discovery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaServer
@PropertySource("bootstrap.yml")
public class DiscoveryServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryServiceApplication.class).run(args);
    }
}
