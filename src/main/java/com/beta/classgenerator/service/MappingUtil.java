package com.beta.classgenerator.service;

import org.springframework.stereotype.Component;

import java.lang.reflect.*;

@Component
public class MappingUtil {
    public void callSetter(Object obj, String fieldName, Object value){
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            field.set(obj, value);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public Object callGetter(Object obj, String fieldName){
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
