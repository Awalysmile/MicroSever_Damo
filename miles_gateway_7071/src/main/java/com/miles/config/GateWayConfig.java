package com.miles.config;

import com.miles.filter.MGateWayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @ClassName GateWayConfig
 * @Description 自定义路由
 * @Author Miles
 * @Date 2019/4/6 12:07
 * @Version 1.0
 */
@Configuration
public class GateWayConfig {

    @Resource
    RouteLocatorBuilder builder;

    @Bean  // 第一个route 路由ribbon 第二路由feign
    public RouteLocator getRouteLocator() {
        return builder.routes()
                .route(ribbon -> ribbon.path("/ribbon/**")
                        .uri("lb://M-COMSUMER-RIBBON")
                        .id("m-ribbon"))
                .route(feign -> feign.path("/feign/**")
                        .filters(feignF -> feignF.stripPrefix(1)
                            .filter(new MGateWayFilter()))
                        .uri("lb://M-COMSUMER-FEIGN")
                        .id("m-feign-one")
                ).build();

    }
}

////    @Resource
////    @Autowired
////    RouteLocatorBuilder builder;
//
//    @Bean // 第一个route 路由ribbon 第二路由feign
//    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                // ribbon
//                .route(ribbon -> ribbon.path("/ribbon/**")
//                        .uri("lb://M-COMSUMER-RIBBON")
//                        .id("m-ribbon-one"))
//                //feign
//                .route(feign -> feign.path("/feign/**").filters(a -> a.stripPrefix(1)
//                        .filter(new MGateWayFilter()))
//                        .uri("lb://M-COMSUMER-FEIGN")
//                        .id("m-feign-two"))
//                .build();
//    }
////    @Bean
////    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
////        return builder.routes()
////                .route(new Function<PredicateSpec, Route.AsyncBuilder>() {
////                    @Override
////                    public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
////                        return predicateSpec.path("/ribbon/**")
////                                .uri("lb://M-COMSUMER-RIBBON")
////                                .id("m-ribbon-one");
////                    }
////                })
////                .route(new Function<PredicateSpec, Route.AsyncBuilder>() {
////                    @Override
////                    public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
////                        return predicateSpec.path("/feign/**").filters(new Function<GatewayFilterSpec, UriSpec>() {
////                            @Override
////                            public UriSpec apply(GatewayFilterSpec gatewayFilterSpec) {
////                                return gatewayFilterSpec.stripPrefix(1).filter(new MGateWayFilter());
////                            }
////                        }).uri("lb://M-COMSUMER-FEIGN")
////                                .id("m-feign-two");
////                    }
////                }).build();
////    }
//
//}
