package com.hu.zan;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2020-01-18 22:21
 * @Description
 **/
public class CaffeineDemo {

    @Test
    public void caffeine() {
        Cache<Object, Object> cache = Caffeine.newBuilder()
                .initialCapacity(2)
                .maximumSize(2)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
        cache.put("hello", "world");
        System.out.println(cache.getIfPresent("hello"));

    }
}
