package com.miles.dService;

import com.alibaba.dubbo.config.annotation.Service;
import com.miles.entity.BaseEntity;

import java.util.Date;

/**
 * @ClassName serviceImpl
 * @Description TODO
 * @Author Miles
 * @Date 2019/4/7 11:12
 * @Version 1.0
 */
@Service
public class serviceImpl implements MDbService {
    @Override
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @Override
    public BaseEntity getOperator() {
        System.out.println("访问数据库");
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setCreatedBy("流浪大师");
        baseEntity.setUpdatedBy(null);
        baseEntity.setDateCreated(new Date(2018));
        baseEntity.setDateUpdate(new Date(2019));
        return baseEntity;
    }
}
