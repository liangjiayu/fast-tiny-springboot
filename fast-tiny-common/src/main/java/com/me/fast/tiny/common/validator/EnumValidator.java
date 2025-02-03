package com.me.fast.tiny.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Method;

public class EnumValidator implements ConstraintValidator<ValidEnum, Object> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 允许 null，若必填需结合 @NotNull
        if (value == null) {
            return true;
        }

        // 如果字段类型是 Integer/String，尝试转换为枚举，注意验证的枚举需要有 fromCode 的方法
        try {
            Method fromCode = enumClass.getMethod("fromCode", value.getClass());
            fromCode.invoke(null, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
