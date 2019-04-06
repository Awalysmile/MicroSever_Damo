package com.miles.config;

import com.miles.filter.MGwGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfigGlobal
 * @Description TODO
 * @Author Miles
 * @Date 2019/4/7 0:26
 * @Version 1.0
 */
@Configuration
public class GateWayConfigGlobal {

    @Bean
    public GlobalFilter getGlobalFilter() {
        return new MGwGlobalFilter();
    }
}
