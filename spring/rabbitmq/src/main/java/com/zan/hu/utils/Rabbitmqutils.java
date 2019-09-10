package com.zan.hu.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-07-06 20:28
 * @Description todo
 **/
public class Rabbitmqutils {

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("118.31.20.148");
        connectionFactory.setPassword("hupeng");
        connectionFactory.setUsername("hupeng");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        return connectionFactory.newConnection();
    }
}
