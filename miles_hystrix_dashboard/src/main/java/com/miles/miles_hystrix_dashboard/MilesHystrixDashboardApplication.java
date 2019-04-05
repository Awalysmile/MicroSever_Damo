package com.miles.miles_hystrix_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // 开启Dashboard
public class MilesHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilesHystrixDashboardApplication.class, args);
    }

}
