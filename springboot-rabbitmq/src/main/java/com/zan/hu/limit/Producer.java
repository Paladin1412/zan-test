package com.zan.hu.limit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zan.hu.utils.Rabbitmqutils;

public class Producer {


    public static void main(String[] args) throws Exception {

        Connection connection = Rabbitmqutils.getConnection();
        Channel channel = connection.createChannel();

        String exchange = "test_qos_exchange";
        String routingKey = "qos.save";

        String msg = "Hello RabbitMQ QOS Message";

        for (int i = 0; i < 5; i++) {
            channel.basicPublish(exchange, routingKey, true, null, msg.getBytes());
        }

    }
}
