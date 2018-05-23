package com.customSerialization.logic.impl;

import com.customSerialization.logic.Serializer;
import com.customSerialization.serializeObject.SerObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SerializerImpl implements Serializer {
    @Override
    public String serializeToJson(Serializable object) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> diffFields = new ArrayList<>();
        stringBuilder.append("{ ");
        for(Field field: object.getClass().getDeclaredFields()){
            try {
                field.setAccessible(true);
                Class thisClass = field.get(object).getClass();
                if(!(SerObject.class.isAssignableFrom(thisClass)))
                stringBuilder.append("\""+field.getName()+"\" : \""+field.get(object)+"\", ");
                else
                    diffFields.add(difficultFieldToJson(field,object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        for(String dm: diffFields){
            stringBuilder.append(dm);
            stringBuilder.append(", ");
        }
        stringBuilder.setCharAt(stringBuilder.length()-2,' ');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private String difficultFieldToJson(Field difField, Serializable object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\""+difField.getName()+ "\" : ");
        stringBuilder.append("{ ");
        Object o = null;
        try {
            o = difField.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        for(Field field: o.getClass().getDeclaredFields()){
            try {
                field.setAccessible(true);
                stringBuilder.append("\""+field.getName()+"\""+" : \""+field.get(o)+"\", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.setCharAt(stringBuilder.length()-2,' ');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }


    @Override
    public String serializeAddressToProps(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Field field: object.getClass().getDeclaredFields()){
            try {
                field.setAccessible(true);
                Class o = field.get(object).getClass();
                if(!(SerObject.class.isAssignableFrom(o)))
                stringBuilder.append(field.getName()+"="+field.get(object)+"\n");
                else
                    stringBuilder.append(difficultFieldToProps(field.get(object)));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return stringBuilder.toString();
    }

    private String difficultFieldToProps(Object o) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Field field: o.getClass().getDeclaredFields()){
            try {
                field.setAccessible(true);
                stringBuilder.append(field.getDeclaringClass().getSimpleName()+"."+field.getName()+"="+field.get(o)+"\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}
