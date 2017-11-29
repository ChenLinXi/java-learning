package com.jason.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class ValidateUtil {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    /**
     * 通过注解校验model的属性值
     */
    public static <T> void validate(T o) throws IllegalArgumentException {
        Set<ConstraintViolation<T>> violations = validatorFactory.getValidator().validate(o);
        if (violations != null && violations.size() > 0) {
            ConstraintViolation<T> violation = violations.iterator().next();
            throw new IllegalArgumentException(violation.getMessage());
        }
    }

    /**
     * 校验对象所有字段
     *
     * @param <T> 参数类型
     * @param o 请求参数
     * @return 验证错误信息列表
     */
    public static <T> List<String> validateAll(T o) {
        List<String> errorList = new ArrayList<String>();
        Set<ConstraintViolation<T>> violations = validatorFactory.getValidator().validate(o);
        if (violations != null && violations.size() > 0) {
            for (ConstraintViolation<T> violation : violations) {
                errorList.add(violation.getMessage());
            }
        }
        return errorList;
    }
}
