package com.zan.hu;

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
