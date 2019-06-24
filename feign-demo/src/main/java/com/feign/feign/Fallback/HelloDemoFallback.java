package com.feign.feign.Fallback;

import com.feign.feign.Model.Teacher;
import com.feign.feign.Service.FeignService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Niclas
 * @create 2019-03-30-22:00
 */
@Component
public class HelloDemoFallback implements FeignService {
    @Override
    public Object geteacher(String id) {
        return "我降级了~~3333";
    }

    @Override
    public int user(String order) {
        return 0;
    }
}
