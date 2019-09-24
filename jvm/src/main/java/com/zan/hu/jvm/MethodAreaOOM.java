package com.zan.hu.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-23 10:43
 * @Description todo
 * 在Java7之前，方法区位于永久代(PermGen)，永久代和堆相互隔离，永久代的大小在启动JVM时可以设置一个固定值，不可变；Java8仍然保留方法区的概念，只不过实现方式不同。
 * 取消永久代，方法存放于元空间(Metaspace)，元空间仍然与堆不相连，但与堆共享物理内存，逻辑上可认为在堆中
 * 测试代码如下，为快速看出结果，请加入VM参数-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:MaxMetaspaceSize=10m：
 **/
public class MethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o,
                    objects));
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
