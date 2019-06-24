package com.ribon.ribondemo.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ribon.ribondemo.Domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Niclas
 * @create 2019-03-30-18:45
 */
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class getTeacherController {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod ="callTimeoutFallback")
    @GetMapping("getTeacher")
    public Object getTeacher(@RequestParam("id")String id){

       return restTemplate.getForObject("http://helloclient/teacher?id="+id+"",Teacher.class);
    }

    public Object callTimeoutFallback(String id){
        return "查询超时啦，我降级了。";
    }
}
