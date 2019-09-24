package com.zan.hu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-23 11:40
 * @Description todo
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String getWelcomeMsg() {
        return "Hello,Spring Security";
    }
}
