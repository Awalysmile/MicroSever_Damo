package com.miles.miles_eureka_8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class MilesEureka10000Application {

    public static void main(String[] args) {
        SpringApplication.run(MilesEureka10000Application.class, args);
    }

}
