package com.miles.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("MILES-PROVIDER-ONE")
public interface IMFeign {

    @RequestMapping("/test")
    String test();

    @RequestMapping("getFromDb")
    String getFromDb();
}
