package com.zan.hu.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 10:22
 * @Description todo
 **/
public class IocMain {
    public static void main(String[] args) {
        Map<String, AtomicInteger> stringAtomicIntegerMap = new HashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();
        stringAtomicIntegerMap.put("aaa", atomicInteger);

        stringAtomicIntegerMap.get("aaa").incrementAndGet();
        System.out.println(stringAtomicIntegerMap.get("aaa").get());
    }


}
