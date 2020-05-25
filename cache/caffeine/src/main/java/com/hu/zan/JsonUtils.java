package com.hu.zan;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/15 18/44
 */
public class JsonUtils {

    public static Map<String, Object> initBasicTemplateMap = new LinkedHashMap() {
        {
            put("serviceOrderCode", "服务单号*");
            put("userNick", "用户昵称*");
            put("serviceItemName", "服务商品名称*");
            put("logisticAuctionsName", "物流商品名称");
            put("storeCode", "仓编码");
            put("feeName", "三级费用项*");
            put("quantity", "单量");
            put("amount", "预提金额（元）*");
            put("bizDate", "业务完成时间*");
            put("remark", "备注");
        }
    };

    public static void main(String[] args) throws Exception {
        //System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));//TestData
        //System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testDataKll"));//test_data

        //List<List<String>> ss = head();
        //ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
        //strings.forEach(s -> {
        //    List<String> temp = new ArrayList<>();
        //    temp.add(s);
        //    ss.add(temp);
        //});
        //System.out.println(ss);
        User user = new User();
        user.setOrderNo("1");
        user.setUserName("23123");
        Class cla = user.getClass();
        Field[] declaredFields = cla.getDeclaredFields();
        for (Field field : declaredFields) {
            // 设置字段可访问， 否则无法访问private修饰的变量值
            //field.setAccessible(true);
            String name = field.getName();
            System.out.println(name);
            //String upperName = name.substring(0, 1).toUpperCase()
            //    + name.substring(1);
            String upperName = getMethodName(name);
            Method method = cla
                .getMethod("get" + upperName);
            Object value = method.invoke(user);
            System.out.println(value);
        }
    }

    private static String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte)((char)items[0] - 'a' + 'A');
        return new String(items);
    }

    private static List<List<String>> head() {
        List<List<String>> head = new ArrayList<>();
        initBasicTemplateMap.forEach((k, v) -> {
            List<String> index = new ArrayList<>();
            index.add(v.toString());
            head.add(index);
        });
        return head;
    }

}
