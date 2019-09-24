package com.zan.hu;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-12 11:48
 * @Description todo
 **/
public class CyclicBarrierMethod {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
        System.out.println(111111);
    });

    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                System.out.println("step 1");
                cyclicBarrier.await();
                System.out.println("step 2");
                cyclicBarrier.await();
                System.out.println("step 3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                System.out.println("step 1");
                cyclicBarrier.await();
                System.out.println("step 2");
                cyclicBarrier.await();
                System.out.println("step 3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();

    }
}
