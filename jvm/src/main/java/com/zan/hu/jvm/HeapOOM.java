package com.zan.hu.jvm;

import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-09-10 15:51
 * @Description todo
 **/
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new LinkedList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
