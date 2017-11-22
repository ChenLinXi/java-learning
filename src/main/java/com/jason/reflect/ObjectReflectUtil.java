package com.jason.reflect;

import java.lang.reflect.Field;

public class ObjectReflectUtil {

    public static String extensionToString(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object fieldValue = field.get(object);
                if (fieldValue != null) {
                    stringBuilder.append(fieldName);
                    stringBuilder.append("=");
                    stringBuilder.append("\"");
                    stringBuilder.append(fieldValue);
                    stringBuilder.append("\"");
                    stringBuilder.append("&");
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (StringIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
