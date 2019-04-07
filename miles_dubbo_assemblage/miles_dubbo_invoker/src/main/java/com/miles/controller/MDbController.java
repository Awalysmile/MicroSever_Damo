package com.miles.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.miles.dService.MDbService;
import com.miles.entity.BaseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MDbController
 * @Description Miles Dubbo Controller
 * @Author Miles
 * @Date 2019/4/7 11:49
 * @Version 1.0
 */
@RestController
public class MDbController {

    @Reference
    private MDbService mDbService;

    @RequestMapping("/hello")
    public String hell() {
        System.out.println("dubbo hello is ok now");
        return mDbService.hello();
    }

    @RequestMapping("/getOperator")
    public BaseEntity getOperator() {
        System.out.println("假装相信对方从数据拿到数据");
        return mDbService.getOperator();
    }
}
