package com.hu.zan;

import lombok.Getter;

/**
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/12 19/11
 */
@Getter
public enum UintEnum {
    A("a", "消息"),
    B("b", "笑笑");
    String code;
    String name;

    UintEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getUintName(UintEnum uintEnum) throws Exception {
        switch (uintEnum.getCode()) {
            case "a":
                return uintEnum.getName();
            case "b":
                return uintEnum.getName();
            default:
                return "1";
        }
    }
}
