package com.ribon.ribondemo.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Niclas
 * @create 2019-03-30-19:45
 * 自定义规则
 */
@Configuration
public class RibbonConfigation {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
