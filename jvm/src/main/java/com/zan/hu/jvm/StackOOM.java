package com.zan.hu.jvm;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 16:12
 * @Description todo
 **/
public class StackOOM {

    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {
        Thread.sleep(1);

        run();
    }
}
