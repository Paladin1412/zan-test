package com.hu.zan;

import org.springframework.web.client.RestTemplate;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-17 14:47
 * @Description todo
 **/
//@Configuration
public class BeanConfiguration {

    //@Bean
    //@LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
