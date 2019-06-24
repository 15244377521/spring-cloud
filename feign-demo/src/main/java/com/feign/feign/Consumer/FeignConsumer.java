package com.feign.feign.Consumer;

import com.feign.feign.Model.Teacher;
import com.feign.feign.Service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Niclas
 * @create 2019-03-30-21:58
 */
@RestController
@RefreshScope
public class FeignConsumer {


    @Autowired
    FeignService feignService;

    @GetMapping("getTeacher")
    public Object getTeacher(@RequestParam("id")String id){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
      System.out.println("开始时间==================="+df.format(new Date()));
       Object o = feignService.geteacher(id);
        System.out.println("结束时间---------------------"+df.format(new Date()));
        return  o;
    }
}
