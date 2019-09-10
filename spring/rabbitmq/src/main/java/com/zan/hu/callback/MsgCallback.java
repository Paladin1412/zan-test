package com.zan.hu.callback;

import com.rabbitmq.client.ConfirmListener;

import java.io.IOException;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-07-06 20:35
 * @Description todo
 **/
public class MsgCallback implements ConfirmListener {
    //失败
    @Override
    public void handleAck(long deliveryTag, boolean multiple) throws IOException {
        System.out.println(deliveryTag + ";" + multiple);
        System.out.println("------ack");
    }

    //成功
    @Override
    public void handleNack(long deliveryTag, boolean multiple) throws IOException {
        System.out.println(deliveryTag + ";" + multiple);
        System.out.println("-------no ack");
    }
}
