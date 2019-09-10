package com.zan.hu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    @GetMapping("/test")
    public void test() {
        userService.ok();
        userService.getMethodName();
    }
}
