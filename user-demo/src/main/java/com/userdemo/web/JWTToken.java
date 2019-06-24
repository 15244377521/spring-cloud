package com.userdemo.web;

/**
 * @author Niclas
 * @create 2019-04-07-17:09
 */
public class JWTToken {
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public JWTToken(String accessToken) {
        super();
        this.accessToken = accessToken;
    }


}
