package com.me.fast.tiny.admin.enums;

import lombok.Getter;

@Getter
public enum GenderEnum {
    MALE(1, "男性"),
    FEMALE(2, "女性"),
    OTHER(3, "其他");

    private final Integer code;
    private final String text;

    GenderEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    /**
     * 根据 code 解析枚举
     */
    public static GenderEnum fromCode(Integer code) {
        for (GenderEnum gender : GenderEnum.values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        return null;
    }
}