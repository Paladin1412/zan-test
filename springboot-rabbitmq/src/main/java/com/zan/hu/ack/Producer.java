package com.zan.hu.ack;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zan.hu.utils.Rabbitmqutils;

import java.util.HashMap;
import java.util.Map;

public class Producer {


    public static void main(String[] args) throws Exception {

        Connection connection = Rabbitmqutils.getConnection();
        Channel channel = connection.createChannel();

        String exchange = "test_ack_exchange";
        String routingKey = "ack.save";


        for (int i = 0; i < 5; i++) {

            Map<String, Object> headers = new HashMap<String, Object>();
            headers.put("num", i);

            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .deliveryMode(2)
                    .contentEncoding("UTF-8")
                    .headers(headers)
                    .build();
            String msg = "Hello RabbitMQ ACK Message " + i;
            channel.basicPublish(exchange, routingKey, true, properties, msg.getBytes());
        }

    }
}
