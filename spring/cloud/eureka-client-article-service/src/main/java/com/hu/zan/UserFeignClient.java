package com.hu.zan;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-29 14:20
 * @Description todo
 **/
@FeignClient(value = "user-service")
public interface UserFeignClient {

    @GetMapping("/user/hello")
    String hello();

}
