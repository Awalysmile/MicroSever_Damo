package com.miles.feign;

import org.springframework.stereotype.Component;

/**
 * @ClassName IMFeignFallBack
 * @Description TODO
 * @Author Miles
 * @Date 2019/4/5 18:28
 * @Version 1.0
 */
@Component // 降级方法要被spring 管理起来
public class IMFeignFallBack implements IMFeign{
    @Override
    public String test() {
        return "当前节点出现异常，多试几次或请稍后重试，如果仍有问题，通知管理员";
    }

    @Override
    public String getFromDb() {
        return "当前节点出现异常，多试几次或请稍后重试，如果仍有问题，通知管理员";
    }
}
