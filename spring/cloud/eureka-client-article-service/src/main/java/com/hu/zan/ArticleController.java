package com.hu.zan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-17 14:49
 * @Description todo
 **/
@RestController
public class ArticleController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/article/callHello")
//    public String hello() {
//        return restTemplate.getForObject("http://user-service/user/hello", String.class);
//    }

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/article/callHello")
    public String hello() {
        return userFeignClient.hello();
    }
}
