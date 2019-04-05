package com.miles.miles_ribbon_7070;

import com.netflix.loadbalancer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication(scanBasePackages = "com.miles")
@EnableEurekaClient
@EnableDiscoveryClient
public class MilesRibbon7070Application {

    public static void main(String[] args) {
        SpringApplication.run(MilesRibbon7070Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean // spring 默认单例？todoK
    public IRule getIRule() {
        Random random = new Random();
        int i = random.nextInt(4);
        if (i <= 1) {
            return new RandomRule();
        }
        if (i<=2) {
            return new ZoneAvoidanceRule();
        }
        if (i<=3) {
            return new WeightedResponseTimeRule();
        }
        return new RetryRule();
    }
}
