package com.zan.hu;

public class ThreadMethod {

    private static final Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> {
            synchronized (resource) {
                System.out.println(Thread.currentThread().getName() + ":get resource lock");
                try {
                    System.out.println(Thread.currentThread().getName() + ":will wait");
                    resource.wait();
                    System.out.println(Thread.currentThread().getName() + ":end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadA");


        Thread threadB = new Thread(() -> {
            synchronized (resource) {
                System.out.println(Thread.currentThread().getName() + ":get resource lock");
                try {
                    System.out.println(Thread.currentThread().getName() + ":will wait");
                    resource.wait();
                    System.out.println(Thread.currentThread().getName() + ":end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadB");


        Thread threadC = new Thread(() -> {
            synchronized (resource) {

                resource.notify();
                System.out.println(Thread.currentThread().getName() + ":will  notify");
            }
        }, "threadC");

        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }
}
