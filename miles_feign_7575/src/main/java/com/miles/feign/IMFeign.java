package com.miles.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient("MILES-PROVIDER-ONE")
@FeignClient(value = "MILES-PROVIDER-ONE",fallback = IMFeignFallBack.class) // 降级 熔断等
public interface IMFeign {

    @RequestMapping("/test")
    String test();

    @RequestMapping("getFromDb")
    String getFromDb();
}
