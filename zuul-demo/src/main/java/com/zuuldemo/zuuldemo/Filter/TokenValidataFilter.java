package com.zuuldemo.zuuldemo.Filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zuuldemo.zuuldemo.jwt.JwtConfiguration;
import com.zuuldemo.zuuldemo.jwt.JwtTokenProvider;
import com.zuuldemo.zuuldemo.jwt.LongConfigationBean;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Niclas
 * @create 2019-04-07-15:41
 */
@Component
public class TokenValidataFilter extends ZuulFilter {




    JwtTokenProvider tokenProvider;

    LongConfigationBean LongConfigationBean;

    @Override
    /**
     * 定义拦截器类型 pre post route
     */
    public String filterType() {
        return "pre";
    }
    public TokenValidataFilter(LongConfigationBean LongConfigationBean, JwtTokenProvider tokenProvider) {
        this.LongConfigationBean = LongConfigationBean;
        this.tokenProvider = tokenProvider;
    }

    /**
     * 执行顺序 数字越小 越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 6;
    }

    /**
     * 拦截器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return !LongConfigationBean.getNoAuthenticationRoutes().contains(ctx.get("proxy"));
    }

    /**noAuthenticationRoutes
     * 主逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //zuul请求上下文对象可以直接取
        RequestContext ctx = RequestContext.getCurrentContext();
        //可以通过上下文对象获取ruquest
        HttpServletRequest request = ctx.getRequest();
        //我们就去通过它的请求头，去获取到token
        String token =request.getHeader("Authorization");

        if(null==token){
        //返回403
            forBidden();
            return null;
        }
        Claims claims = tokenProvider.parseToken(token);
        if(null==claims){
       //返回403
            forBidden();
            return null;
        }
        System.out.println("当前请求的token对象是："+ JSONObject.toJSONString(claims));
        return null;
    }


   void forBidden(){
        RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.FORBIDDEN.value());
       ReflectionUtils.rethrowRuntimeException(new ZuulException("无权限访问！！！！",HttpStatus.FORBIDDEN.value(),"权限校验失败"));
   }

    public JwtTokenProvider getTokenProvider() {
        return tokenProvider;
    }

    public void setTokenProvider(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    public com.zuuldemo.zuuldemo.jwt.LongConfigationBean getLongConfigationBean() {
        return LongConfigationBean;
    }

    public void setLongConfigationBean(com.zuuldemo.zuuldemo.jwt.LongConfigationBean longConfigationBean) {
        LongConfigationBean = longConfigationBean;
    }
}
