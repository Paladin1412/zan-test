package com.zan.hu;

import com.zan.hu.scanner.ProxyRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean
    public ProxyRegister proxyRegister() {
        return new ProxyRegister("com.example.demo.service");
    }
}
