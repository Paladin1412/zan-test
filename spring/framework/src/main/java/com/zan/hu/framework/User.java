package com.zan.hu.framework;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 10:42
 * @Description todo
 **/
@Data
public class User implements InitializingBean {

    private String username;

    private int age;

    private boolean success;

    public User() {
        System.out.println("User的构造函数被执行啦");
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", success=" + success +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet方法");
    }

    public void initMethod() {
        System.out.println("调用initMethod方法");
    }
}
