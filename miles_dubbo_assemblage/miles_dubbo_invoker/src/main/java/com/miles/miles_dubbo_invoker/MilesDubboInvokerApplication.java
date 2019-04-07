package com.miles.miles_dubbo_invoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.miles")
@EnableEurekaClient
@EnableDiscoveryClient
public class MilesDubboInvokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilesDubboInvokerApplication.class, args);
    }

}
