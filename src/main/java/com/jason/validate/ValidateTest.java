package com.jason.validate;

import com.jason.validate.model.ValidateRequest;

public class ValidateTest {

    public static void main(String[] args) {
        ValidateRequest validateRequest = new ValidateRequest();

        try {
            ValidateUtil.validate(validateRequest);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
}
