package com.miles.filter;

import com.miles.emun.GateWayOrder;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName MGateWayFilter
 * @Description test filter of gateway
 * @Author Miles
 * @Date 2019/4/6 11:11
 * @Version 1.0
 */
public class MGateWayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("请求拦截" + exchange.getRequest().getURI().getPath());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        System.out.println("order is working");
        return GateWayOrder.IP_FILTER.getOrder();
    }
}
