package com.miles.miles_provider_9090;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.miles")
@EnableEurekaClient
public class MilesProvider9090Application {

    public static void main(String[] args) {
        SpringApplication.run(MilesProvider9090Application.class, args);
    }

}