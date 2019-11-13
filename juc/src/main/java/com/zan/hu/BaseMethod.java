package com.zan.hu;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-09 11:30
 * @Description todo
 **/
public class BaseMethod {

    public static void main(String[] args) {
        String time = "2019-10-01 09:00:00";
        int i = time.lastIndexOf(":");
        String substring = time.substring(0, i);
        System.out.println(substring);
    }
}
