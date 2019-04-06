package com.miles.filter;

import com.miles.emun.GateWayOrderEnum;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

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
        ServerHttpResponse response = exchange.getResponse();
        if (Objects.requireNonNull(response.getStatusCode()).value() == HttpStatus.OK.value()) {
            // todo 服务不ok exchange 可以做些事情
            // todo 此处api太复杂，有时间封装一下。
            ServerHttpRequest request = exchange.getRequest();
            System.out.println("太复杂了");
            // fallback　提供了默认数据　需要做些标记。
            if (request.getURI().getPath().contains("fallback")) {
                request.getHeaders().add("fallback", "true");
                response.getHeaders().add("fallback", "true");
            }
            // 前端据此操作


        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return GateWayOrderEnum.GLOBAL_FILTER_ORDER.getOrder();
    }
}
