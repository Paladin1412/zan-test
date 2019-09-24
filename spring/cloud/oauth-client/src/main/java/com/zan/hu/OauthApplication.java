package com.zan.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-23 11:07
 * @Description todo
 * http://localhost:8764/oauth/authorize?response_type=code&client_id=client1&redirect_uri=http://www.baidu.com--获取code
 * http://localhost:8764/oauth/token?response_type=code&client_id=client1&grant_type=authorization_code&client_secret=123456&redirect_uri=http://www.baidu.com&code=WvEVHx---获取token
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }
}
