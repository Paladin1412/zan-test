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
        IocServiceImpl.Mail mail
                = applicationContext.getBean("mail", IocServiceImpl.Mail.class);
        System.out.println(mail.getAddress());
    }
}
