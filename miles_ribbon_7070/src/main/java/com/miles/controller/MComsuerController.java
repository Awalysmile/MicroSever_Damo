package com.miles.controller;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
public class MComsuerController {

    private static String URL = "http://MILES-PROVIDER-ONE/test";
    @Resource
    RestTemplate restTemplate;


    @RequestMapping("/fuck")
    public String fuck() {
        // url localhost去注册中心找到名称替换localhost
        // no instance for localhost 报错。如果有localhost实例且有对应的mapping映射，不会报错。
        // 这个地方修改代码需要重启启动类 因为相当于修改过代码
        String ribbonResult = restTemplate.getForObject(URL, String.class);
        System.out.println("fuck: --? " + ribbonResult);
        return "fuck";
    }

    @GetMapping("/hello")
    public String hello() {
        String forObject = restTemplate.getForObject(URL, String.class);
        System.out.println("MProvider9090 被调用");
        return "MProvider9090 被调用" + forObject;
    }

    @RequestMapping("/hell1")
    public HashMap<String, Object> hell1() {

        HashMap<String, Object> resultMap = Maps.newHashMap();

//      // 如响应码、contentType、contentLength、响应消息体等
        ResponseEntity forEntity = restTemplate.getForEntity(URL, String.class);
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


}
