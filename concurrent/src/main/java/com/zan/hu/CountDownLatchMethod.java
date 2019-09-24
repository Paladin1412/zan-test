package com.zan.hu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-12 11:24
 * @Description todo
 **/
public class CountDownLatchMethod {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getId() + "即将睡眠");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getId() + "睡眠结束");
            } catch (Exception e) {

            } finally {
                countDownLatch.countDown();
            }
            System.out.println("child threadOne over");
        });

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getId() + "即将睡眠");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getId() + "睡眠结束");
            } catch (Exception e) {

            } finally {
                countDownLatch.countDown();
            }
            System.out.println("child threadTwo over");
        });

        System.out.println("all thread over");

        countDownLatch.await();
        executorService.shutdown();
    }
}
