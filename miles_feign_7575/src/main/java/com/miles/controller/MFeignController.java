package com.miles.controller;

import com.miles.feign.IMFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName FeignController
 * @Description TODO
 * @Author Miles
 * @Date 2019/4/5 16:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/feign")
public class MFeignController {

    @Resource
    private IMFeign imFeign;

    @RequestMapping("/hello")
    public String hello() {
        String test = imFeign.test();
        System.out.println("feign hello ");
        return "feign hello " + test;
    }


    @RequestMapping("/getFromDb")
    public String getFromDb() {
        return imFeign.getFromDb();
    }
}
