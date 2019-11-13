package com.zan.hu.delayqueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-15 09:43
 * @Description todo
 **/
public class DelayedQueneTest {

    public static void main(String[] args) throws InterruptedException {
        Item item1 = new Item("item1", 5000, TimeUnit.SECONDS);
        Item item2 = new Item("item2", 10000, TimeUnit.SECONDS);
        Item item3 = new Item("item3", 15000, TimeUnit.SECONDS);
        DelayQueue<Item> queue = new DelayQueue<>();
        queue.put(item1);
        queue.put(item2);
        queue.put(item3);
        System.out.println("begin time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        for (int i = 0; i < 3; i++) {
            Item take = queue.take();
            System.out.format("name:{%s}, time:{%s}\n", take.name, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        }

        System.out.println(System.currentTimeMillis()-System.nanoTime());
    }
}

