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
//        ServerHttpRequest request = exchange.getRequest(); // request
//        Object xxx = exchange.getRequiredAttribute("xxx");// required request
//        Mono<MultiValueMap<String, String>> formData = exchange.getFormData();//表单数据
//        Map<String, Object> attributes = exchange.getAttributes(); //attributes
//
//        System.out.println("请求拦截" + request.getURI().getPath());
        System.out.println("假装拦截了");
        return chain.filter(exchange);
    }

    @Override // 过滤顺序，越小权重越高
    public int getOrder() {
        System.out.println("order is working");
        return GateWayOrder.IP_FILTER.getOrder();
    }
}
