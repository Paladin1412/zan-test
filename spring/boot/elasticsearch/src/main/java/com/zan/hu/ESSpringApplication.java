package com.zan.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-21 17:30
 * @Description todo
 **/
@SpringBootApplication
@EnableConfigurationProperties(ElasticsearchConfig.class)
public class ESSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ESSpringApplication.class, args);
    }
}
