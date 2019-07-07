package com.zan.hu.ack;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.zan.hu.utils.Rabbitmqutils;

public class Consumer {

	
	public static void main(String[] args) throws Exception {


		Connection connection = Rabbitmqutils.getConnection();
		Channel channel = connection.createChannel();
		String exchangeName = "test_ack_exchange";
		String queueName = "test_ack_queue";
		String routingKey = "ack.#";
		
		channel.exchangeDeclare(exchangeName, "topic", true, false, null);
		channel.queueDeclare(queueName, true, false, false, null);
		channel.queueBind(queueName, exchangeName, routingKey);
		
		// 手工签收 必须要关闭 autoAck = false
		channel.basicConsume(queueName, false, new MyConsumer(channel));
		
		
	}
}
