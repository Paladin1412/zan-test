package com.zan.hu.limit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zan.hu.utils.Rabbitmqutils;

public class Consumer {


    public static void main(String[] args) throws Exception {

        Connection connection = Rabbitmqutils.getConnection();
        Channel channel = connection.createChannel();


        String exchangeName = "test_qos_exchange";
        String queueName = "test_qos_queue";
        String routingKey = "qos.#";

        channel.exchangeDeclare(exchangeName, "topic", true, false, null);
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);

        //1 限流方式  第一件事就是 autoAck设置为 false

        channel.basicQos(0, 1, false);

        channel.basicConsume(queueName, false, new MyConsumer(channel));


    }
}
