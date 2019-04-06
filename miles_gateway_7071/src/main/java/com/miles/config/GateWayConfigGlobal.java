package com.miles.config;

import com.miles.filter.MGwGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

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

    @Bean(name = "milesRemoteAddressKeyResolver")
    public KeyResolver getKeyResolver() {
//        return a -> Mono.just(a.getRequest().getURI().getPath()); // 根据uri限流
        return a -> Mono.just(Objects.requireNonNull(a.getRequest().getRemoteAddress()).getHostName()); // 根据ip限流
    }
}
