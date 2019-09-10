package com.zan.hu.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 10:22
 * @Description todo
 **/
public class IocMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//        IocServiceImpl iocServiceImpl = applicationContext.getBean("iocServiceImpl", IocServiceImpl.class);
//        iocServiceImpl.say();
        User user1 = applicationContext.getBean("user", User.class);
        User user2 = applicationContext.getBean("user", User.class);
        System.out.println(user1 == user2);
    }
}
