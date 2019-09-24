package com.zan.hu.framework;

import lombok.Data;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 09:59
 * @Description todo
 **/
public class IocServiceImpl implements IocService {

    @Override
    public void say() {
        System.out.println("hello");
    }


    @Data
    public static class Mail {
        private String address;
    }
}
