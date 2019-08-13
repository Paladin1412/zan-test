package com.zan.hu;

@Configuration
public class DemoConfiguration {

    @Bean
    public ProxyRegister proxyRegister() {
        return new ProxyRegister("com.example.demo.service");
    }
}
