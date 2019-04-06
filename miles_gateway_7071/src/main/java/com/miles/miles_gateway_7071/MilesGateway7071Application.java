package com.miles.miles_gateway_7071;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.miles")
@EnableEurekaClient
public class MilesGateway7071Application {

    public static void main(String[] args) {
        SpringApplication.run(MilesGateway7071Application.class, args);
    }

}
