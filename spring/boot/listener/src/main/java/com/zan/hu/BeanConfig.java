package com.zan.hu;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-15 16:24
 * @Description todo
 **/
@Configuration
public class BeanConfig {

    @Bean
    public ServletContextInitializer contextInitializer() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("appkey", "123");
        return servletContext -> {
//            System.out.println("初始化 contextInitializer 参数为： " + JSON.toJSONString(parameters));
            parameters.forEach((k, v) -> servletContext.setInitParameter(k, String.valueOf(v)));
        };
    }

    @Bean
    public ServletListenerRegistrationBean<RayServletContextListener> rayServletContextListener() {
        return new ServletListenerRegistrationBean<>(new RayServletContextListener());
    }
}
