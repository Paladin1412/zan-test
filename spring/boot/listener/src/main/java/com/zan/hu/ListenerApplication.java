package com.zan.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-15 16:22
 * @Description todo
 **/
@SpringBootApplication
//@ServletComponentScan(value = "com.zan.hu")
public class ListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }
}
