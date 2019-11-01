package com.zan.hu.delayqueue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-10-15 09:42
 * @Description todo
 **/
@Data
public class Item implements Delayed {

    private long time;
    String name;


    public Item(String name, long time, TimeUnit unit) {
        this.name = name;
        this.time = System.nanoTime() + TimeUnit.NANOSECONDS.convert(time, TimeUnit.MILLISECONDS);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //System.out.println(l);
        //return time - System.currentTimeMillis();
//        long convert = unit.convert(time - System.nanoTime(), TimeUnit.NANOSECONDS);
//        System.out.println(convert);
//        return unit.convert(time - System.nanoTime(), TimeUnit.NANOSECONDS);
        return unit.convert(time - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

//    @Override
//    public int compareTo(Delayed o) {
//        Item item = (Item) o;
//        long diff = this.time - item.time;
//        if (diff <= 0) {// 改成>=会造成问题
//            return -1;
//        } else {
//            return 1;
//        }
//    }

    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }

        if (o instanceof Item) {
            Item info = (Item) o;
            long diff = time - info.time;

            if (diff > 0) {
                return 1;
            }

            if (diff <= 0) {
                return -1;
            }
        }

        long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);

        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

}
