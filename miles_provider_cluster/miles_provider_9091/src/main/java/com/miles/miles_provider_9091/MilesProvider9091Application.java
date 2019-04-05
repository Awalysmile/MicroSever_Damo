package com.miles.miles_provider_9091;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.miles")
@EnableEurekaClient
public class MilesProvider9091Application {

    public static void main(String[] args) {
        SpringApplication.run(MilesProvider9091Application.class, args);
    }

}
