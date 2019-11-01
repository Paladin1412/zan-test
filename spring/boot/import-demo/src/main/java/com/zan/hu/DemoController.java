package com.zan.hu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-11 10:12
 * @Description todo
 **/
@RestController
@RequestMapping
public class DemoController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/say")
    public void say() {
        userService.say();
    }
}
