package com.feign.feign.Service;

import com.feign.feign.Fallback.HelloDemoFallback;
import com.feign.feign.Model.Teacher;
import feign.Body;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Niclas
 * @create 2019-03-30-21:58
 */
@FeignClient(name = "HELLOCLIENT",fallback = HelloDemoFallback.class )
@Component
public interface FeignService {
   @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public Object geteacher(@RequestParam("id")String id);

   @Body("%7B\"order\":\"{order}\"%7D")
   @RequestMapping(value = "",method = RequestMethod.GET)
   public int user(@Param("order")String order);
}
