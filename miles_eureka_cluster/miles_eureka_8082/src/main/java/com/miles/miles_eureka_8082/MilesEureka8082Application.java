package com.miles.miles_eureka_8082;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class MilesEureka8082Application {

    public static void main(String[] args) {
        SpringApplication.run(MilesEureka8082Application.class, args);
    }

}
