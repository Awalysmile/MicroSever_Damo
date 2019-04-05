package com.miles.miles_feign_7575;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.miles")
@EnableEurekaClient
@EnableDiscoveryClient
// feign 调用巨坑 伪装调用需要指定基包
@EnableFeignClients(basePackages = "com.miles.feign")
public class MilesFeign7575Application {

    public static void main(String[] args) {
        SpringApplication.run(MilesFeign7575Application.class, args);
    }

    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServletRgsterBean() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new HystrixMetricsStreamServlet());
        bean.addUrlMappings("/hystrix.stream");
        return bean;
    }

}
