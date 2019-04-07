package com.miles.miles_dubbo_worker;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.miles.dService")
public class MilesDubboWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilesDubboWorkerApplication.class, args);
    }

}
