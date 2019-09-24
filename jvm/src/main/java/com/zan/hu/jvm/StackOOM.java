package com.zan.hu.jvm;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 16:12
 * @Description todo
 * 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常
 **/
public class StackOOM {

    /**
     * 栈大小
     */
    private int stackLength = 1;

    /**
     * 递归压栈
     */
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOOM stackOverflowTest = new StackOOM();
        try {
            stackOverflowTest.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length is :" + stackOverflowTest.stackLength);
            throw e;
        }

    }

    /**
     *  如果虚拟机在扩展栈无法申请到足够的内存空间，则抛出OutOfMemoryError异常
     */
    static class StackOverflowTest {

        /**
         * 栈大小
         */
        private int stackLength = 1;

        /**
         * 递归压栈
         */
        public void stackLeak() {
            stackLength++;
            stackLeak();
        }

        public static void main(String[] args) {
            StackOverflowTest stackOverflowTest = new StackOverflowTest();
            try {
                stackOverflowTest.stackLeak();
            } catch (Throwable e) {
                System.out.println("stack length is :" + stackOverflowTest.stackLength);
                throw e;
            }

        }

    }
}
