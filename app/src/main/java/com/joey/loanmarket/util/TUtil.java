package com.joey.loanmarket.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */
public class TUtil {
    public static <T> T getT(Object o, int i) {
        Type type = o.getClass().getGenericSuperclass();
        if (type!=null){
            if (type instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class<T> params = (Class<T>) parameterizedType.getActualTypeArguments()[i];
                if (params!=null){
                    try {
                        return params.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
