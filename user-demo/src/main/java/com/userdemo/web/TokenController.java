package com.userdemo.web;

import com.userdemo.jwt.JwtConfiguration;
import com.userdemo.jwt.JwtTokenProvider;
import com.userdemo.jwt.UAAClaims;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author Niclas
 * @create 2019-04-07-17:10
 */
@RestController
@RequestMapping("/")
public class TokenController {

    @Autowired
    JwtConfiguration configuration;

    @Autowired
    JwtTokenProvider tokenProwider;

    // 获取一个根据手机号和密码获取token
    @PostMapping("/token/byPhone")
    public ResponseEntity<?> getTokenByPhone(@RequestBody User user) {
        // 这个实例中没有加入其它逻辑
        // TODO 你可以去数据库里面查有没有这个用户，密码对不对。如果密码不对你就不给他返回token。
        //伪代码: User user = user.selectByUsername(user);
        //if(user == null){
        //   return ResultModel;  **ResultModel为我们封装的结果类
        //
        // }
//		//return ResponseEntity.ok(new JWTToken(jwtTokenProvider.createToken(parseClaims(user)))); **同样的我们可以将我们这一套逻辑封装到result结果集中
//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

        return ResponseEntity.ok(new JWTToken(tokenProwider.createToken(parseClaims(user))));
    }

    // UAAClaims这个对象就是token中的内容
    private UAAClaims parseClaims(User user) {
        UAAClaims uaaClaims = new UAAClaims();
        uaaClaims.setIssuer(configuration.getIss());
        uaaClaims.setIssuedAt(new Date());
        uaaClaims.setAudience(String.valueOf(user.getAccountId()));
        uaaClaims.setId(UUID.randomUUID().toString());
        uaaClaims.setUserName(user.getUserName());
        uaaClaims.setExpiration(new Date(System.currentTimeMillis() + configuration.getExpm() * 1000 * 60));
        uaaClaims.setEmail(user.getEmail());
        uaaClaims.setPhone(user.getPhone());
        uaaClaims.setSubject(String.valueOf(user.getAccountId()));
        uaaClaims.setNotBefore(new Date());
        return uaaClaims;

    }


    // 将token反解出来，看看里面的内容；
    // 仅用于开发场景
    @RequestMapping("/token/parse")
    public Claims parseToken(String token) {
        return tokenProwider.parseToken(token);
    }
}
