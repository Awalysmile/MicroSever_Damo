package com.miles.controller;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @ClassName MComsuerController
 * @Description TODO
 * @Author Miles
 * @Date 2019/4/5 12:13
 * @Version 1.0
 */
@SuppressWarnings("unused")
@RestController
public class MRibbonController {

    private static String TEST = "http://MILES-PROVIDER-ONE/test";
    private static String GET_FROM_DB = "http://MILES-PROVIDER-ONE/getFromDb";
    private static String DUBBO_HELLO = "http://MILES-D-INVERKER/hello";
    private static String DUBBO_GET_INFO = "http://MILES-D-INVERKER/getOperator";

    @Resource
    RestTemplate restTemplate;

    // todo dubbo 路由调用失败？？
    @RequestMapping("/dubbo/hello")
    public String invokerDubboHello() {
        System.out.println("dubbo invoke hello");
        return restTemplate.getForObject(DUBBO_HELLO, String.class);
    }

    // ribbon 路由调用成功
    @RequestMapping("/ribbon/hello")
    public String invokerDubboHello1() {
        System.out.println("dubbo invoke hello");
        return restTemplate.getForObject(DUBBO_HELLO, String.class);
    }


    // todo 调用失败 因为application name 在gateway中没有配置或在该name没有找到对应的mapping
    @RequestMapping("/dubbo/getOperator")
    public String invokerDubboGetOperator1() {
        System.out.println("get operator invoker");
        return restTemplate.getForObject(DUBBO_GET_INFO, String.class);

    }

    // 调用成功
    @RequestMapping("/ribbon/getOperator")
    public String invokerDubboGetOperator() {
        System.out.println("get operator invoker");
        return restTemplate.getForObject(DUBBO_GET_INFO, String.class);
    }

    @RequestMapping("ribbon/fuck")
    public String fuck() {
        // url localhost去注册中心找到名称替换localhost
        // no instance for localhost 报错。如果有localhost实例且有对应的mapping映射，不会报错。
        // 这个地方修改代码需要重启启动类 因为相当于修改过代码
        String ribbonResult = restTemplate.getForObject(TEST, String.class);
        System.out.println("fuck: --? " + ribbonResult);
        return "fuck";
    }

//    @GetMapping("/ribbon/hello")
//    public String hello() {
//        String forObject = restTemplate.getForObject(TEST, String.class);
//        System.out.println("MProvider9090 被调用");
//        return "MProvider9090 被调用" + forObject;
//    }

    @RequestMapping("ribbon/hell1")
    public HashMap<String, Object> hell1() {

        HashMap<String, Object> resultMap = Maps.newHashMap();

//      // 如响应码、contentType、contentLength、响应消息体等
        ResponseEntity forEntity = restTemplate.getForEntity(TEST, String.class);
        HttpStatus statusCode = forEntity.getStatusCode();
        resultMap.put("statusCode", statusCode);

        HttpHeaders headers = forEntity.getHeaders();
        resultMap.put("headers", new Gson().toJson(headers));


        // todo ?
//        UriTemplateHandler uriTemplateHandler = restTemplate.getUriTemplateHandler();
        // httpMessageConverter
//        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();

        // todo
//        ResponseErrorHandler errorHandler = restTemplate.getErrorHandler();
        System.out.println("return MProvider9090 被调用");

//        resultMap.put("messageConverters", messageConverters);
//        resultMap.put("uriTemplateHandler", uriTemplateHandler);
//        resultMap.put("errorHandler", errorHandler);

        return resultMap;
    }


    // 服务降级 提供名字不需要加括号`()`否则不起作用。
    @HystrixCommand(fallbackMethod = "getFromDbFallback")
    @RequestMapping("ribbon/getFromDb")
    public String getFromDb() {
        return restTemplate.getForObject(GET_FROM_DB, String.class);
    }

    /**
     * 降级方法
     *
     * @return
     */
    public String getFromDbFallback() {
        System.out.println("字节点出现异常，请通知管理员");
        return "字节点出现异常，请通知管理员";
    }
}
