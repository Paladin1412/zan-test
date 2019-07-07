package com.zan.hu.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @version 1.0
 * @Author admin
 * @Date 2019-04-03 08:46
 * @Description todo
 **/
@SpringCloudApplication
@EnableFeignClients
@EnableHystrix
public class UploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadApplication.class, args);
    }
}
