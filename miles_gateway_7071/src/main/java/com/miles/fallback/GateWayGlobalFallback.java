package com.miles.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GateWayGlobalFallback
 * @Description TODO
 * @Author Miles
 * @Date 2019/4/7 0:42
 * @Version 1.0
 */
@RestController
public class GateWayGlobalFallback {

    @RequestMapping("milesGateWayFallbackRibbon")
    public String ribbonFallback() {
        System.out.println("服务方有异常");
        return "System.out.println(\"服务方有异常\")";
    }

    @RequestMapping("milesGateWayFallbackFeign")
    public String feignFallback() {
        System.out.println("feign failed");
        return "feign failed";
    }
}
