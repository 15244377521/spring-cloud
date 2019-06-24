package com.zuuldemo.zuuldemo.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Niclas
 * @create 2019-04-07-19:07
 */
@Component
@ConfigurationProperties("wenlong.zuul.token-filter")
public class LongConfigationBean {

    //将我们要放行的路由放进来
    List<String> noAuthenticationRoutes;

    public List<String> getNoAuthenticationRoutes() {
        return noAuthenticationRoutes;
    }

    public void setNoAuthenticationRoutes(List<String> noAuthenticationRoutes) {
        this.noAuthenticationRoutes = noAuthenticationRoutes;
    }

    public LongConfigationBean(List<String> noAuthenticationRoutes) {
        this.noAuthenticationRoutes = noAuthenticationRoutes;
    }
}
