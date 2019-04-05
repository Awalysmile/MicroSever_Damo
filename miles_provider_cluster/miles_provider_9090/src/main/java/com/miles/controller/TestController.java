package com.miles.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController
 * @Description  test controller of provider 9090
 * @Author Miles
 * @Date 2019/4/5 11:22
 * @Version 1.0
 */
@SuppressWarnings("unused")
@Controller
public class TestController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("调用了当前服务" + port);
        return "调用了当前服务" + port;
    }

}
