package com.miles.filter;

import com.miles.emun.GateWayOrderEnum;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName MGwGlobalFilter
 * @Description TODO
 * @Author Miles
 * @Date 2019/4/7 0:17
 * @Version 1.0
 */
@SuppressWarnings("unused")
public class MGwGlobalFilter implements Ordered, GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("测试一下全局过滤器的效果");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return GateWayOrderEnum.GLOBAL_FILTER_ORDER.getOrder();
    }
}
