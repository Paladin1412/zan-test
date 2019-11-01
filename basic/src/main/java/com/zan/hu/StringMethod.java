package com.zan.hu;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-16 16:45
 * @Description todo
 **/
public class StringMethod {

    public static void main(String[] args) {
//        DoubleAdder dailyAverageNumberOfWorkOrdersEnteredSum = new DoubleAdder();
//        for (int i = 0; i < 10; i++) {
//            double random = Math.random();
//            System.out.println(random);
//            dailyAverageNumberOfWorkOrdersEnteredSum.add(random);
//        }
//
//        System.out.println(dailyAverageNumberOfWorkOrdersEnteredSum.sum());
//        long minute = 1 * 60 * 1000;
//        System.out.println(minute / 1000 / 60);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            if (i % 2 == 0)
                user.setName(user.getName() + i);
            user.setAge(i);
            users.add(user);
        }
        Map<String, Long> collect = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.counting()));
        collect.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

    }

    public static String convertTimeToString(Long time) {
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("HH时mm分ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }


    @Data
    public static class User {
        String name = "hupeng";
        int age;
    }

}
