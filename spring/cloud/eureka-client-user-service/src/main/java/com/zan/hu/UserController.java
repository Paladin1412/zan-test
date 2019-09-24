package com.zan.hu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-17 14:40
 * @Description todo
 **/
@RestController
public class UserController {

    @GetMapping("/user/hello")
    public String hello() {
        return "hello";
    }
}
