package com.zan.hu.framework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-17 17:40
 * @Description todo
 **/
@Aspect
public class AspectJDeal {

    @Pointcut("execution(* *.say(..))")
    public void test() {
    }

    @Before("test()")
    public void before() {
        System.out.println("before test..");
    }

    @After("test()")
    public void after() {
        System.out.println("after test..");
    }

    @Around("test()")
    public Object around(ProceedingJoinPoint p) {
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }
}
