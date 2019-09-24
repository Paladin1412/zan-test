package com.zan.hu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 15:51
 * @Description todo
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *  .-Xms20m:设置JVM最小内存为20m。此值可以设置与-Xmx相同，以避免每次垃圾回收完成后JVM重新分配内存
 *  .-Xmx20m:设置JVM最大可用内存20M
 *  .-XX:+HeapDumpOnOutOfMemoryError 表示当JVM发生OOM时，自动生成DUMP文件
 * http://www.spring4all.com/article/16640
 **/
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
